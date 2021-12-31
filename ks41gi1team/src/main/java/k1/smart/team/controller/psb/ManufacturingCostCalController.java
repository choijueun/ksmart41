package k1.smart.team.controller.psb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.psb.ManufacturingCostCalService;

@Controller
@RequestMapping(value="/k1ManufacturingCostCal")
public class ManufacturingCostCalController {
	private ManufacturingCostCalService manufacturingCostCalService;
	public ManufacturingCostCalController(ManufacturingCostCalService manufacturingCostCalService) {
		this.manufacturingCostCalService = manufacturingCostCalService;
	}
		
	@GetMapping("/k1ManufacturingCostCalList")
	public String k1ManufacturingCostCalMain(Model model) {
		model.addAttribute("title", "제조원가계산");
		return "manufacturingCostCal/manufacturingCostCal_list";
	}
}
