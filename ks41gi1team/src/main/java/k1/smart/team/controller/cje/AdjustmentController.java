package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.AdjustmentService;

@Controller
@RequestMapping("/k1Adjustment")
public class AdjustmentController {
	private AdjustmentService adjService;
	public AdjustmentController(AdjustmentService adjService) {
		this.adjService = adjService;
	}

	@GetMapping("")
	public String adjustmentMain(Model model) {
		model.addAttribute("title", "재고조정내역");
		return "storing/adjustment/adjustment_list";
	}
	
	@GetMapping("/{stockAdjCode}")
	public String adjInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "재고조정 상세내역");
		model.addAttribute("stockAdjCode", stockAdjCode);
		return "storing/adjustment/adjustment_info";
	}
	
	@GetMapping("/add")
	public String addAdj(Model model) {
		model.addAttribute("title", "재고조정내역추가");
		return "storing/adjustment/adjustment_add";
	}
	
	@GetMapping("/modify/{stockAdjCode}")
	public String modifyAdj(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "재고조정 상세내역");
		model.addAttribute("stockAdjCode", stockAdjCode);
		return "storing/adjustment/adjustment_modify";
	}
}
