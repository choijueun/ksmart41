package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.AdjustmentService;

@Controller
@RequestMapping("/k1Adjustment")
public class AdjustmentController {
	private AdjustmentService adjService;
	private String mainBusinessCode; //사업장대표코드
	private List<Storing> adjList; //재고조정내역 배열
	private Storing adjInfo; //재고조정내역 상세정보
	
	/**
	 * 생성자 메서드
	 * @param adjService
	 */
	public AdjustmentController(AdjustmentService adjService) {
		this.adjService = adjService;
	}
	
	@GetMapping("")
	public String adjustmentMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		adjList = adjService.getAllAdjList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "재고조정내역");
		model.addAttribute("adjList", adjList);
		
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
