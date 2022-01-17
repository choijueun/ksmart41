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
import k1.smart.team.service.cje.StoringService;

@Controller
public class AdjustmentController {
	private final StoringService storingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드
	private List<Storing> adjList; //재고조정내역 배열
	private Map<String, Object> resultMap;
	
	/**
	 * 생성자 메서드
	 * @param adjService
	 */
	public AdjustmentController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 재고조정내역 전체조회
	 * @param model
	 */
	@GetMapping("/k1Adjustment")
	public String adjustmentMain(Model model) {
		//재고조정내역 전체목록 List<Storing>
		adjList = storingService.getAllAdjList(mainBusinessCode);
		model.addAttribute("adjList", adjList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		
		return "storing/adjustment/adjustment_list";
	}
	
	/**
	 * 재고조정내역 상세조회
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Adjustment/{stockAdjCode}")
	public String adjInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Adjustment";
		
		//재고조정내역 상세정보 조회결과
		resultMap = storingService.getAdjInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Adjustment";
		
		//재고조정내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("adjInfo"));
		//재고조정내역 상세정보 List<Storing>
		model.addAttribute("adjDetail", resultMap.get("adjDetailList"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		
		return "storing/adjustment/adjustment_info";
	}
	
	/**
	 * 재고조정내역 신규등록(+재고하나정보)
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1AdjustmentAdd")
	public String addAdj(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보를 model 속성에 추가
			model.addAttribute("s", storingService.getStockForStoring(mainBusinessCode, inventoryCode));
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고조정내역 등록");
		
		return "storing/adjustment/adjustment_add";
	}
	
	/**
	 * 재고조정내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1AdjustmentModify/{stockAdjCode}")
	public String modifyAdj(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Adjustment";
		
		model.addAttribute("stockAdjCode", stockAdjCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		
		return "storing/adjustment/adjustment_modify";
	}
}
