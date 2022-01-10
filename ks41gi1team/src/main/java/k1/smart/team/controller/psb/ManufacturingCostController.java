package k1.smart.team.controller.psb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.psb.ManufacturingCostService;

@Controller
@RequestMapping(value="/k1ManufacturingCost")
public class ManufacturingCostController {

	private ManufacturingCostService manufacturingCostService;
	
	public ManufacturingCostController(ManufacturingCostService manufacturingCostService) {
		this.manufacturingCostService = manufacturingCostService;
	}
	
	@GetMapping("/")
	public String k1getManufacturingCost() {
		return "manufacturingCost/manufacturingCost_list";
	}
}
