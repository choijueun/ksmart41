package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ProductOrder productOrderInfo;
	private List<ProductOrder> productOrderInfoList;
	private Map<String, Object> resultMap;
	
	//생성자 주입
	public ProductOrderController(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}
	
	//수주 삭제
	@PostMapping("/k1ProductOrderRemove")
	public String k1ProductOrderRemove() {
		String result = productOrderService.k1ProductOrderRemove();
		return "redirect:/productOrder/productOrder_list";
	}
	
	//수주관리 상세
	@SuppressWarnings("unchecked")
	@GetMapping("history/{productOrderCode}")
	public String ProductOrderInfo(
			@PathVariable(value="productOrderCode", required=false) String productOrderCode
			,Model model) {
		//수주관리 코드검사
		if(productOrderCode == null || "".equals(productOrderCode)) {
			System.out.println("수주코드 에러");
			return "redirect:/k1ProductOrder/history";
		}
		//수주관리 상세
		resultMap = productOrderService.getProductOrderInfo(productOrderCode);
		if(resultMap == null) {
			System.out.println("수주관리코드 에러");
			return "redirect:/k1ProductOrder/history";
		}
		
		productOrderInfo = (ProductOrder) resultMap.get("productOrderInfo");
		productOrderInfoList = (List<ProductOrder>) resultMap.get("productOrderInfoList");
		
		model.addAttribute("SectionTitle", "수주관리");
		model.addAttribute("SectionLocation", "수주 상세정보");
		model.addAttribute("productOrderInfo", productOrderInfo);
		model.addAttribute("productOrderInfoList", productOrderInfoList);
		return "productOrder/productOrder_detail";
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
