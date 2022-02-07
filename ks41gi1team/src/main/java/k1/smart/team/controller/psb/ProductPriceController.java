package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.pjh.Is;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ManufacturingCost;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.ProductOrder;
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
	private Object productPriceInfo;
	
	
	
	public ProductPriceController(ProductPriceService productPriceService, MainBusinessService mainBusinessService, ItemService itemService, UserService userService, IsService isService, ManufacturingCostService manufacturingCostService) {
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
	
	//단가 등록
	@GetMapping("/k1ProductPriceReg")
	public String addProductOrder(Model model) {

		System.out.println("/addProductPriceReg GET 방식 요청");
		model.addAttribute("title", "제품단가 등록");

		  
		  List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
		  model.addAttribute("mainBusinessList", mainBusinessList);
		  System.out.println("mainBusinessList" + mainBusinessList);
		  
		  List<Stock> itemList = itemService.getAllItemList(paramMap);
		  model.addAttribute("itemList", itemList);
		  System.out.println("itemList" + itemList);

		  List<ManufacturingCost> manufacuringCostList =manufacturingCostService.getManufacturingCostList();
		  model.addAttribute("manufacuringCostList", manufacuringCostList);
		  System.out.println("manufacuringCostList" + manufacuringCostList);
		  
		  List<Is> isList = isService.getInvoiceList();
		  model.addAttribute("isList", isList);
		  System.out.println("isList" + isList);
		  
		  List<User> userList = userService.getAllUserList();
		  model.addAttribute("userList", userList);
		  System.out.println("userList" + userList);
		
		//제품단가 새로등록할때마다 새로운 제품단가코드 생성
			String getProductPriceCode = productPriceService.getProductPriceCode();
			model.addAttribute("getProductPriceCode", getProductPriceCode);
			System.out.println("getProductPriceCode--->" + getProductPriceCode);
		  
		  
		return "productPrice/productPrice_register";
	}
	
	//제품단가 등록
	@PostMapping("/k1ProductPriceReg")
	public String addProductPrice(ProductPrice productPrice) {
		
		System.out.println("ProductPriceController 제품단가등록 화면에서 입력받은 값:" + productPrice);
		//insert 처리
		//null 체크
		String productPriceCode = productPrice.getProductPriceCode();
		if(productPriceCode != null && !"".equals(productPriceCode)) {
			productPriceService.addProductPrice(productPrice);
		}
		return "redirect:/k1ProductPrice/k1ProductPriceList";
		
	}
	
	//제품단가 코드 체크
		@PostMapping("/k1ProductPriceCodeCheck")
		@ResponseBody
		public boolean productPriceCodeCheck(@RequestParam(value="productPriceCode", required = false) String productPriceCode) {
			
			System.out.println("ajax 통신으로 요청받은 파라미터 productPriceCode:" + productPriceCode);
			
			boolean checkResult = false;
			
			int check = productPriceService.getProductPriceByProductPriceCode(productPriceCode);
			
			if(check > 0) checkResult = true;
			System.out.println("checkResult" + checkResult);
			return checkResult;
		}
	
	//제품단가 상세	
		@GetMapping("/productPrice/{productPriceCode}")
		public String productPriceInfo(@PathVariable(value = "productPriceCode", required = false) String productPriceCode,
				Model model) {
			// 제품단가 코드 검사 if(productPriceCode == null
			System.out.println("productPriceCode-->" + productPriceCode);
			if (productPriceCode == null || "".equals(productPriceCode)) {
				System.out.println("제품단가코드 ERROR");
				return "redirect:/k1ProductPrice/k1ProductPriceList";
			}
			
			// 제품단가 상세정보
			productPriceInfo = productPriceService.getProductPriceInfo(productPriceCode);
			if (productPriceInfo == null) {
				System.out.println("제품단가코드 ERROR");
				return "redirect:/k1ProductPrice/k1ProductPriceList";
			}
			
			model.addAttribute("title", "제품단가 상세");
			model.addAttribute("SectionTitle", "제품단가관리");
			model.addAttribute("SectionLocation", "상세정보");
			model.addAttribute("productPriceInfo", productPriceInfo);
			return "productPrice/productPrice_info";
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
