package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.AdjustmentService;

@Controller
public class AdjustmentController {
	private AdjustmentService adjService;
	private String mainBusinessCode; //사업장대표코드
	private List<Storing> stockAdjList; //재고조정내역 배열
	private Storing stockAdjInfo; //재고조정내역 상세정보
	
	/**
	 * 생성자 메서드
	 * @param adjService
	 */
	public AdjustmentController(AdjustmentService adjService) {
		this.adjService = adjService;
	}
	
	@GetMapping("/k1Adjustment")
	public String adjustmentMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		//재고조정내역 전체목록
		stockAdjList = adjService.getAllAdjList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "재고조정내역");
		model.addAttribute("stockAdjList", stockAdjList);
		
		return "storing/adjustment/adjustment_list";
	}
	
	@GetMapping("/k1Adjustment/{stockAdjCode}")
	public String adjInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		stockAdjInfo = adjService.getAdjInfo(stockAdjCode);
		stockAdjList = adjService.getAdjDetailInfo(stockAdjCode);
		
		
		model.addAttribute("title", "재고조정 상세내역");
		model.addAttribute("stockAdjInfo", stockAdjInfo);
		model.addAttribute("stockAdjDetail", stockAdjList);
		return "storing/adjustment/adjustment_info";
	}
	
	@GetMapping("/k1AdjustmentAdd")
	public String addAdj(Model model) {
		model.addAttribute("title", "재고조정내역추가");
		return "storing/adjustment/adjustment_add";
	}
	
	@GetMapping("/k1AdjustmentModify/{stockAdjCode}")
	public String modifyAdj(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "재고조정 상세내역");
		model.addAttribute("stockAdjCode", stockAdjCode);
		return "storing/adjustment/adjustment_modify";
	}
}
