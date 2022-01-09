package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	private boolean chk;
	
	private static final Logger log = LoggerFactory.getLogger(ItemController.class);
	
	/**
	 * 생성자 메서드
	 * @param itemService
	 */
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * 품목관리 전체목록 조회 @GetMapping("/k1Item")
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
	
	/**
	 * 품목정보등록 첫 화면 @GetMapping("/k1ItemAdd")
	 * @param model
	 * @return
	 */
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
	 * AJAX: 품목카테고리 반환 @RequestMapping(value = "/itemCategory", method = RequestMethod.POST)
	 * @param largeCategory
	 * @param middleCategory
	 * @param smallCategory
	 * @return Map<String,Object> largeCategory, middleCategory, smallCategory, microCategory
	 */
	@RequestMapping(value = "/itemCategory", method = RequestMethod.POST)
	public String getItemCategory(
			@RequestParam Map<String, String> paramMap, Model model){
		//parameter 확인
		String largeCategory = paramMap.get("largeCategory");
		String middleCategory = paramMap.get("middleCategory");
		String smallCategory = paramMap.get("smallCategory");
		//출력
		StringJoiner param = new StringJoiner(", ");
		param.add("largeCategory=" + largeCategory)
			 .add("middleCategory=" + middleCategory)
			 .add("smallCategory=" + smallCategory);
		log.info("PARAMETER 	:: {}", param);
		
		resultMap= itemService.getItemCategory(largeCategory, middleCategory, smallCategory);
		if(largeCategory != null && !"".equals(largeCategory)) model.addAttribute("middleCategory", resultMap.get("middleCategory"));
		if(middleCategory != null && !"".equals(middleCategory)) model.addAttribute("smallCategory", resultMap.get("smallCategory"));
		if(smallCategory != null && !"".equals(smallCategory)) model.addAttribute("microCategory", resultMap.get("microCategory"));
		
		return "stock/item/item_add :: #itemCategory";
		//데이터 받을 페이지 :: #데이터 받을 객체
	}
	
	/**
	 * AJAX: 품목명 중복 검사 @PostMapping("/k1ItemNameValid")
	 * @param itemName
	 * @return boolean
	 */
	@PostMapping("/k1ItemNameValid")
	@ResponseBody
	public boolean itemNameValid(
			@RequestParam(value="itemName", required = false) String itemName) {
		
		log.info("PARAMETER 	:: {}", itemName);
		if(itemName == null || "".equals(itemName)) return false;
		
		chk = itemService.itemNameValid(mainBusinessCode, itemName);
		
		return chk;
	}
	
	/**
	 * 품목정보 등록 절차 수행 @PostMapping("/k1ItemAdd")
	 * @param paramMap
	 * @return
	 */
	@PostMapping("/k1ItemAdd")
	public String addItem(Stock itemInfo) {
		//parameter 확인
		itemInfo.setMainBusinessCode(mainBusinessCode);
		log.info("PARAMETER 	:: {}", itemInfo.toString());
		
		chk = itemService.addItem(itemInfo);
		
		if(chk) return "redirect:/k1Item";
		else return "redirect:/k1ItemAdd";
	}
	
	/**
	 * 품목정보 수정 첫 화면 @GetMapping("/k1ItemModify/{itemCode}")
	 * @param itemCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ItemModify/{itemCode}")
	public String modifyItem(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		//품목코드 검사
		if(itemCode == null || "".equals(itemCode)) return "redirect:/k1Item";
		
		resultMap = itemService.getItemInfo(itemCode);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목수정");
		model.addAttribute("itemInfo", resultMap.get("itemInfo"));
		return "stock/item/item_modify";
	}
	
	@GetMapping("/k1ItemCategory")
	public String itemCategory(Model model) {
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "카테고리");
		return "stock/item/item_category";
	}
}
