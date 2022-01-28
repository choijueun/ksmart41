package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class AdjustmentController {
	private final StoringService storingService;
	private Map<String, Object> resultMap;
	private Stock stockInfo; //재고정보
	private Storing storingInfo; //재고조정내역
	private static final Logger log = LoggerFactory.getLogger(AdjustmentController.class);
	
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
	public String adjustmentMain(Model model, HttpSession session) {
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//사업장대표코드
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockReasonCode", 6);

		//전체목록 List<Storing>
		model.addAttribute("storingList", storingService.getStoringList(paramMap));
		
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
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Adjustment";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 6);
		//상세정보 조회
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Adjustment";
		
		//한줄정보 Storing
		model.addAttribute("s", resultMap.get("storingInfo"));
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고차이조정");
		
		return "storing/adjustment/adjustment_info";
	}
	
	/**
	 * 재고조정내역 신규등록 화면(+재고하나정보)
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1AdjustmentAdd")
	public String addAdj(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model, HttpSession session) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring((String) session.getAttribute("MAINBUSINESSCODE"), inventoryCode);
			log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고조정내역 등록");
		
		return "storing/adjustment/adjustment_add";
	}
	
	/**
	 * 재고조정내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1AdjustmentAdd")
	public String addAdj(Storing storingInfo) {
		//재고조정내역 등록 프로세스
		
		return "redirect:/k1Adjustment";
	}
	
	/**
	 * 재고조정내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1AdjustmentModify/{stockAdjCode}")
	public String modifyAdj(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Adjustment";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 6);
		//상세정보 조회결과
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//한줄정보 Storing
		storingInfo = (Storing) resultMap.get("storingInfo");
		log.info("자재입고내역 수정화면 INFO :: {}", storingInfo);
		model.addAttribute("s", storingInfo);
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "재고조정내역 수정");
		
		return "storing/adjustment/adjustment_modify";
	}
	
	/**
	 * 재고조정내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1AdjustmentModify")
	public String modifyAdj(Storing storingInfo) {
		//재고조정내역 수정프로세스
		
		return "redirect:/k1Adjustment";
	}
	
	/**
	 * 재고조정내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1AdjustmentRemove")
	public String removeAdj(Storing storingInfo) {
		//재고조정내역 삭제 프로세스
		
		return "redirect:/k1Adjustment";
	}
}
