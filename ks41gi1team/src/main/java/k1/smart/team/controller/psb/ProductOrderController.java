package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.service.psb.ContractService;
import k1.smart.team.service.psb.ProductOrderService;

@Controller
@RequestMapping(value="/k1ProductOrder")
public class ProductOrderController {

	private ProductOrderService productOrderService;
	private String mainBusinessCode;
	
	//생성자 주입
	public ProductOrderController(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}
	
	
	
	//수주 등록
		@PostMapping("/k1ProductOrderReg")
		public String addProductOrder(ProductOrder productOrder) {
			
			System.out.println("ProductOrderController 회원등록 화면에서 입력받은 값:" + productOrder);
			//insert 처리
			//null 체크
			String productOrderCode = productOrder.getProductOrderCode();
			if(productOrderCode != null && !"".equals(productOrderCode)) {
				productOrderService.addProductOrder(productOrder);
			}
			
			return "productOrder/productOrder_register";
			
		}
		
		  @GetMapping("/k1ProductOrderReg") 
		  public String addProductOrder(Model model) {
		  
			  System.out.println("/addProductOrder GET 방식 요청"); 
			  model.addAttribute("title","수주등록");
		
			  //DB 계약코드 LIST List<ProductOrder> ProductOrderList =
			  List<ProductOrder> productOrderList =  productOrderService.getProductOrderList(); 
			  model.addAttribute("productOrderList", productOrderList);
		
			  return "productOrder/productOrder_register"; 
		  
		  }
	
	
	//하나의 수주 조회
	@PostMapping("/k1ProductOrderOne") 
	public String getSearchProductOrderList( @RequestParam(value="searchKey", required = false) String searchKey
										,@RequestParam(value="searchValue", required = false)String searchValue
										,Model model) {
		System.out.println(searchKey);
		System.out.println(searchValue);
		
		if(searchKey != null && "productOrderCode".equals(searchKey)) {
		searchKey = "productOrderCode";
		}else if(searchKey != null && "mainBusinessCode".equals(searchKey)) {
		searchKey = "mainBusinessCode";
		  
		}else if(searchKey != null && "contractCode".equals(searchKey)) {
		searchKey = "contractCode";
		  
		}else if(searchKey != null && "clientCode".equals(searchKey)) {
		searchKey = "clientCode";
		
		}else if(searchKey != null && "productPriceCode".equals(searchKey)) {
		searchKey = "productPriceCode";
		
		}else if(searchKey != null && "totalProductCount".equals(searchKey)) {
		searchKey = "totalProductCount";
		
		}else if(searchKey != null && "totalProductPrice".equals(searchKey)) {
		searchKey = "totalProductPrice";
		
		}else if(searchKey != null && "productOrderDate".equals(searchKey)) {
		searchKey = "productOrderDate";
		
		}else if(searchKey != null && "predictProductDate".equals(searchKey)) {
		searchKey = "predictProductDate";
		
		}else if(searchKey != null && "status".equals(searchKey)) {
		searchKey = "status";
		
		}else if(searchKey != null && "briefs".equals(searchKey)) {
		searchKey = "briefs";
		
		}else if(searchKey != null && "regDate".equals(searchKey)) {
		searchKey = "regDate";
		
		}else{
		searchKey = "updateDate";
		}
		  // 검색키 검색어를 통해서 계약목록 조회
			System.out.println(searchKey);
			System.out.println(searchValue);
		  List<ProductOrder> productOrderList = productOrderService.getProductOrderListBySearchKey(searchKey, searchValue);
		  System.out.println(productOrderList);
		  // 조회된 회원목록 model에 값을 저장
		  model.addAttribute("title", "수주목록");
		  model.addAttribute("productOrderList", productOrderList);
		  
		  
		  return "productOrder/productOrder_list";
	  }
	  
	
	
	//전체 수주 조회
	@GetMapping("/k1ProductOrderList")
	public String productMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul001";
		List<ProductOrder> productOrderList = productOrderService.getAllProductOrderList(mainBusinessCode);
		  model.addAttribute("title", "수주목록");
		  model.addAttribute("productOrderList", productOrderList);
		  
		  return "productOrder/productOrder_list";
	}
}
