package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.ItemService;

@Controller
@RequestMapping(value="/k1Item")
public class ItemController {
	private ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("")
	public String itemMain(Model model) {
		model.addAttribute("title", "품목관리");
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
