package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.ItemService;

@Controller
@RequestMapping(value="/k1Item")
public class ItemController {
	private ItemService itemService;
	private String mainBusinessCode; //사업장대표코드
	private List<Stock> itemList; //품목 여러개 정보
	private Stock itemInfo; //품목 하나 정보
	
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
	@GetMapping("")
	public String itemMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		itemList = itemService.getAllItemList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("itemList", itemList);
		return "stock/item/item_list";
	}
	
	@GetMapping("/{itemCode}")
	public String itemInfo(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		itemCode = "itemCode_"+itemCode;
		model.addAttribute("title", "품목정보");
		model.addAttribute("itemCode", itemCode);
		return "stock/item/item_info";
	}
	
	@GetMapping("/add")
	public String addItem(Model model) {
		model.addAttribute("title", "품목정보추가");
		return "stock/item/item_add";
	}
	
	@GetMapping("/modify/{itemCode}")
	public String modifyItem(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		itemCode = "itemCode_"+itemCode;
		model.addAttribute("title", "품목정보수정");
		model.addAttribute("itemCode", itemCode);
		return "stock/item/item_modify";
	}
	
	@GetMapping("/category")
	public String itemCategory(Model model) {
		model.addAttribute("title", "품목카테고리");
		return "stock/item/item_category";
	}
}
