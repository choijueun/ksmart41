package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.Cost;
import k1.smart.team.service.pjh.CostService;

@Controller
@RequestMapping(value = "/k1CostList")
public class CostController {
	private CostService costService;
	private String mainBusinessCode;
	
	public CostController(CostService costService) {
		this.costService = costService;
	}
	
	//기타비용 전체 목록
	@GetMapping("")
	public String costMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<Cost> costList = costService.getAllCostList(mainBusinessCode);
		
		model.addAttribute("title", "기타비용 관리");
		model.addAttribute("costList", costList);
		
		return "cost/cost_list";
	}
	
	
}
