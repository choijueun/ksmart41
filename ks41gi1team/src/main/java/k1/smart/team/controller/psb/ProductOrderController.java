package k1.smart.team.controller.psb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.service.psb.ContractService;
import k1.smart.team.service.psb.ProductOrderService;

@Controller
public class ProductOrderController {

	private ProductOrderService productOrderService;
	private String mainBusinessCode;
	
	//생성자 주입
	public ProductOrderController(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}
	
	@GetMapping("/k1ProductOrderReg")
	public String k1addProductOrder() {
		return "productOrder/productOrder_register";
	}
	@GetMapping("/k1ProductOrderList")
	public String k1ProductOrderList() {
		return "productOrder/productOrder_list";
	}
}
