package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.ItemService;

@Controller
public class ItemController {
	private ItemService itemService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Stock itemInfo; //품목 하나 정보
	private List<Stock> itemList; //품목 배열
	private Map<String,Object> resultMap;
	private List<String> stringList;
	private boolean chkBoolean;
	/**
	 * 생성자 메서드
	 * @param itemService
	 */
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * 품목관리 전체목록 조회
	 * @param model
	 * @return item_list
	 */
	@GetMapping("/k1Item")
	public String itemMain(Model model) {
		//품목 전체목록
		itemList = itemService.getAllItemList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("itemList", itemList);
		return "stock/item/item_list";
	}
	
	/**
	 * 품목정보 상세조회
	 * @param itemCode
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Item/{itemCode}")
	public String itemInfo(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		//품목코드 검사
		if(itemCode == null || "".equals(itemCode)) return "redirect:/k1Item";
		
		//품목 상세정보
		resultMap = itemService.getItemInfo(itemCode);
		if(resultMap == null) return "redirect:/k1Item";
		
		itemInfo = (Stock) resultMap.get("itemInfo");
		itemList = (List<Stock>) resultMap.get("stockList");
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목정보");
		model.addAttribute("itemInfo", itemInfo);
		model.addAttribute("stockList", itemList);
		return "stock/item/item_info";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/k1ItemAdd")
	public String addItem(Model model) {
		
		//카테고리목록
		resultMap = itemService.getItemCategory(null, null, null);
		stringList = (List<String>) resultMap.get("largeCategory");
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목추가");
		model.addAttribute("largeCategory", stringList);
		
		return "stock/item/item_add";
	}
	
	/**
	 * AJAX: 품목카테고리 반환
	 * @param largeCategory
	 * @param middleCategory
	 * @param smallCategory
	 * @return Map<String,Object> largeCategory, middleCategory, smallCategory, microCategory
	 */
	@PostMapping("/k1ItemCategory")
	@ResponseBody
	public Map<String,Object> itemCategory(
			@RequestParam(value="largeCategory", required = false) String largeCategory,
			@RequestParam(value="middleCategory", required = false) String middleCategory,
			@RequestParam(value="smallCategory", required = false) String smallCategory
			){
		//parameter 확인
		StringJoiner param = new StringJoiner(", ");
		param.add("largeCategory=" + largeCategory)
			 .add("middleCategory=" + middleCategory)
			 .add("smallCategory=" + smallCategory);
		System.out.println("PARAMETER :: [ "+param+" ]");
		
		resultMap = itemService.getItemCategory(largeCategory, middleCategory, smallCategory);
		
		return resultMap;
	}
	/**
	 * AJAX: 품목명 중복 검사
	 * @param itemName
	 * @return boolean
	 */
	@PostMapping("/k1ItemNameValid")
	@ResponseBody
	public boolean itemNameValid(
			@RequestParam(value="itemName", required = false) String itemName) {
		if(itemName == null || "".equals(itemName)) return false;
		System.out.println("itemName="+itemName);
		//chkBoolean =  
		
		return chkBoolean;
	}
	
	//품목정보 등록
	@PostMapping("/k1ItemAdd")
	public String addItem(
			@RequestParam(value="itemName", required = false) String itemName,
			@RequestParam(value="itemType", required = false) String itemType,
			@RequestParam(value="itemStandard", required = false) String itemStandard,
			@RequestParam(value="itemOrigin", required = false) String itemOrigin,
			@RequestParam(value="largeCategory", required = false) String largeCategory,
			@RequestParam(value="middleCategory", required = false) String middleCategory,
			@RequestParam(value="smallCategory", required = false) String smallCategory,
			@RequestParam(value="microCategory", required = false) String microCategory,
			@RequestParam(value="itemComment", required = false) String itemComment
			) {
		//parameter 확인
		StringJoiner param = new StringJoiner(", ");
		param.add("itemName=" + itemName)
			 .add("itemType=" + itemType)
			 .add("itemStandard=" + itemStandard)
			 .add("itemOrigin=" + itemOrigin)
			 .add("largeCategory=" + largeCategory)
			 .add("middleCategory=" + middleCategory)
			 .add("smallCategory=" + smallCategory)
			 .add("microCategory=" + microCategory)
			 .add("itemComment=" + itemComment);
		System.out.println("PARAMETER :: [ "+param+" ]");
		
		int pro = itemService.addItem(mainBusinessCode, itemName, itemType, itemStandard, itemOrigin
									, largeCategory, middleCategory, smallCategory, microCategory, itemComment);
		
		if(pro == 1) return "redirect:/k1Item";
		else return "redirect:/k1ItemAdd";
	}
	
	@GetMapping("/k1ItemModify/{itemCode}")
	public String modifyItem(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		//품목코드 검사
		if(itemCode == null || "".equals(itemCode)) return "redirect:/k1Item";
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목수정");
		model.addAttribute("itemCode", itemCode);
		return "stock/item/item_modify";
	}
	
	@GetMapping("/k1ItemCategory")
	public String itemCategory(Model model) {
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "카테고리");
		return "stock/item/item_category";
	}
}
