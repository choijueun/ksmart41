package k1.smart.team.controller.psb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.psb.ProductPriceCalService;

@Controller
@RequestMapping(value="/k1productPriceCal")
public class ProductPriceCalController {
	private ProductPriceCalService productPriceCalService;
	public ProductPriceCalController(ProductPriceCalService productPriceCalService) {
		this.productPriceCalService = productPriceCalService;
	};
	
	@GetMapping("/k1productPriceCalList")
	public String ProductPriceCalMain(Model model) {
		model.addAttribute("title", "제품원가계산");
		return "productPriceCal/productPriceCal_list";
	}
}
