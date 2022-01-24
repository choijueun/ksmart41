package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.psb.ProductPrice;
import k1.smart.team.service.psb.ProductPriceService;

@Controller
@RequestMapping(value="/k1ProductPrice")
public class ProductPriceController {
	private ProductPriceService productPriceService;
	private List<ProductPrice> productPriceList;
	
	
	
	public ProductPriceController(ProductPriceService productPriceService) {
		this.productPriceService = productPriceService;
	};
	
	@GetMapping("/k1ProductPriceList")
	public String ProductPriceMain(Model model) {
		
		List<ProductPrice> productPriceList = productPriceService.getProductPriceList();
		model.addAttribute("title", "제품단가");
		model.addAttribute("productPriceList", productPriceList);
		System.out.println("productPriceList" + productPriceList);
		
		if(CommonUtils.isEmpty(productPriceList)) {
			  
			  System.out.println("productPriceList"+ productPriceList +"컨트롤러 null이다.");
			  // 널(null)이거나 공백(빈칸)일 경우 실행
			  
		  } else {
			 System.out.println("productPriceList"+ productPriceList +"컨트롤러 null이 아니다.");
			  // 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
			  
		  }
		
		return "productPrice/productPrice_list";
	}
}
