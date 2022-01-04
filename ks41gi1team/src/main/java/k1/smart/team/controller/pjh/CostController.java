package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.Cost;
import k1.smart.team.service.pjh.CostService;

@Controller
@RequestMapping(value = "/k1CostList")
public class CostController {
	private CostService costService;
	private String mainBusinessCode;
	private Cost costInfo; //비용 하나 정보
	
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
	
	//비용 상세정보
	@GetMapping("/{etcPurchaseCode}")
	public String costInfo(
			@PathVariable(value="etcPurchaseCode", required=false) String etcPurchaseCode
			,Model model) {
		if(etcPurchaseCode == null || "".equals(etcPurchaseCode)) {
			System.out.println("비용코드 ERROR");
			return "redirect:/k1CostList";
		}
		
		costInfo = costService.getCostInfoByCode(etcPurchaseCode);
		if(costInfo == null) {
			System.out.println("비용코드 ERROR");
			return "redirect:/k1CostList";
		}
		
		model.addAttribute("title", "기타비용: 상세정보");
		model.addAttribute("costInfo", costInfo);
		return "cost/cost_detail";
	}	
	
	@GetMapping("/add")
	public String addCost(Model model) {
		model.addAttribute("title", "기타비용: 등록");
		return "cost/cost_register";
	}
	
	@GetMapping("/modify/{etcPurchaseCode}")
	public String modifyCost(
			@PathVariable(value="etcPurchaseCode", required=false) String etcPurchaseCode
			,Model model) {
		model.addAttribute("title", "기타비용: 수정");
		model.addAttribute("etcPurchaseCode", etcPurchaseCode);
		return "cost/cost_modify";
	}
	
	
}
