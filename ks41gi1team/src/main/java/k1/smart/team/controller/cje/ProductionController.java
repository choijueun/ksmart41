package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.service.cje.ProductionService;

@Controller
public class ProductionController {
	private ProductionService productionService;
	public ProductionController(ProductionService productionService) {
		this.productionService = productionService;
	}
	
	@GetMapping("")
	public String productionMain(Model model) {
		return "storing/production/production_list";
	}

	@GetMapping("/{stockAdjCode}")
	public String productionInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/production/production_info";
	}
	
	@GetMapping("/add")
	public String addProduction(Model model) {
		return "storing/production/production_add";
	}
	
	@GetMapping("/modify/{stockAdjCode}")
	public String modifyProduction(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/production/production_modify";
	}
}
