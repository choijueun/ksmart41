package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.AdjustmentService;

@Controller
public class AdjustmentController {
	private AdjustmentService adjService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드
	private List<Storing> adjList; //재고조정내역 배열
	private Storing adjInfo; //재고조정내역 상세정보
	private Map<String, Object> resultMap;
	
	/**
	 * 생성자 메서드
	 * @param adjService
	 */
	public AdjustmentController(AdjustmentService adjService) {
		this.adjService = adjService;
	}
	
	/**
	 * 재고조정내역 전체조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Adjustment")
	public String adjustmentMain(Model model) {
		adjList = adjService.getAllAdjList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		model.addAttribute("adjList", adjList);
		
		return "storing/adjustment/adjustment_list";
	}
	
	/**
	 * 재고조정내역 상세조회
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Adjustment/{stockAdjCode}")
	public String adjInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Adjustment";
		
		resultMap = adjService.getAdjInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Adjustment";
		
		adjInfo = (Storing) resultMap.get("adjInfo");
		adjList = (List<Storing>) resultMap.get("adjDetailList");
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		model.addAttribute("s", adjInfo); //한줄
		model.addAttribute("adjDetail", adjList); //상세(배열)
		
		return "storing/adjustment/adjustment_info";
	}
	
	/**
	 * 재고조정내역 신규등록(+재고하나정보)
	 * @param inventoryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1AdjustmentAdd")
	public String addAdj(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고조정내역 등록");
		
		if(CommonUtils.isEmpty(inventoryCode)) return "storing/adjustment/adjustment_add";
		
		model.addAttribute("s", adjService.getStockForStoring(mainBusinessCode, inventoryCode));
		
		return "storing/adjustment/adjustment_add";
	}
	
	@GetMapping("/k1AdjustmentModify/{stockAdjCode}")
	public String modifyAdj(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Adjustment";
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		model.addAttribute("stockAdjCode", stockAdjCode);
		return "storing/adjustment/adjustment_modify";
	}
}
