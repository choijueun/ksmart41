package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.ItemService;

@Controller
public class ItemController {
	private ItemService itemService;
	private String mainBusinessCode; //사업장대표코드
	private Stock itemInfo; //품목 하나 정보
	private List<Stock> itemList; //품목 배열
	private Map<String,Object> resultMap;
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
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		//품목 전체목록
		itemList = itemService.getAllItemList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("itemList", itemList);
		return "stock/item/item_list";
	}
	
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
	
	@GetMapping("/k1ItemAdd")
	public String addItem(Model model) {
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목추가");
		return "stock/item/item_add";
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
