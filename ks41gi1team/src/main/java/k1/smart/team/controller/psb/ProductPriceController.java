package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.pjh.Is;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ManufacturingCost;
import k1.smart.team.dto.psb.ProductPrice;
import k1.smart.team.service.cje.ItemService;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.UserService;
import k1.smart.team.service.pjh.IsService;
import k1.smart.team.service.psb.ManufacturingCostService;
import k1.smart.team.service.psb.ProductPriceService;

@Controller
@RequestMapping(value="/k1ProductPrice")
public class ProductPriceController {
	private ProductPriceService productPriceService;
	private MainBusinessService mainBusinessService;
	private ManufacturingCostService manufacturingCostService;
	private ItemService itemService;
	private UserService userService;
	private IsService isService;

	private Map<String, Object> paramMap;
	
	
	
	public ProductPriceController(ProductPriceService productPriceService, MainBusinessService mainBusinessService, ItemService itemService, UserService userService, IsService IsService, ManufacturingCostService manufacturingCostService) {
		this.productPriceService = productPriceService;
		this.mainBusinessService = mainBusinessService;
		this.itemService = itemService;
		this.userService = userService;
		this.isService = isService;
		this.manufacturingCostService = manufacturingCostService;
	}
	
	@GetMapping("/k1ProductPriceList")
	public String ProductPriceMain(Model model) {
		
		List<ProductPrice> productPriceList = productPriceService.getProductPriceList();
		model.addAttribute("title", "제품단가");
		model.addAttribute("productPriceList", productPriceList);
		System.out.println("productPriceList" + productPriceList);
		
		List<ManufacturingCost> manufacturingCostList = manufacturingCostService.getManufacturingCostList();
		model.addAttribute("manufacturingCostList", manufacturingCostList);
		
		if(CommonUtils.isEmpty(productPriceList)) {
			  
			  System.out.println("productPriceList"+ productPriceList +"컨트롤러 null이다.");
			  // 널(null)이거나 공백(빈칸)일 경우 실행
			  
		  } else {
			 System.out.println("productPriceList"+ productPriceList +"컨트롤러 null이 아니다.");
			  // 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
			  
		  }
		
		return "productPrice/productPrice_list";
	}
	
	//단가 수정
	@GetMapping("/modify/{productCode}")
	@Nullable
	public String modifyProductPrice(@RequestParam(value="productPriceCode", required=false) String productPriceCode
			,Model model) {
		
		List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
		model.addAttribute("mainBusinessList", mainBusinessList);
		
		List<Stock> itemList = itemService.getAllItemList(paramMap);
		model.addAttribute("itemList", itemList);
		
		List<User> userList = userService.getAllUserList();
		model.addAttribute("userList", userList);
		
		List<Is> isList = isService.getInvoiceList();
		model.addAttribute("isList", isList);
		
		List<ManufacturingCost> manufacturingCostList = manufacturingCostService.getManufacturingCostList();
		model.addAttribute("manufacturingCostList", manufacturingCostList);
		
		model.addAttribute("title", "단가관리: 수정");
		model.addAttribute("productPriceCode", productPriceCode);
		
		return "productPrice/productPrice_modify";
	}
	
	//단가 수정후 목록
	@PostMapping("/modify")
	public String modifyProductPrice(ProductPrice productPrice) {
		
	
		productPriceService.modifyProductPrice(productPrice);
		
		return "redirect:/k1ProductPrice/k1ProductPriceList";
	}
}
