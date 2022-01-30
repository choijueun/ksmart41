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
public class ProductionController {
	private final StoringService storingService;
	private Stock stockInfo; //재고정보
	private Storing storingInfo; //생산내역
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	/**
	 * 생성자 메서드
	 * @param productionService
	 */
	public ProductionController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 제품생산내역 전체목록조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Production")
	public String productionMain(Model model, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//사업장대표코드
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockReasonCode", 3);
		
		//전체목록 List<Storing>
		model.addAttribute("storingList", storingService.getStoringList(paramMap));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		
		return "storing/production/production_list";
	}

	/**
	 * 제품생산내역 상세정보 조회
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Production/{stockAdjCode}")
	public String productionInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 3);
		//상세정보 조회
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		//한줄정보 Storing
		model.addAttribute("s", resultMap.get("storingInfo"));
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));

		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		
		return "storing/production/production_info";
	}
	
	/**
	 * 제품생산내역 신규등록(+재고하나정보)
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ProductionAdd")
	public String addProduction(
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
		model.addAttribute("SectionLocation", "제품생산내역 등록");
		
		return "storing/production/production_add";
	}
	
	/**
	 * 제품생산내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ProductionAdd")
	public String addProduction(Storing storingInfo) {
		//제품생산내역 등록 프로세스
		
		return "redirect:/k1Production";
	}
	
	/**
	 * 제품생산내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ProductionModify/{stockAdjCode}")
	public String modifyProduction(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 3);
		//상세정보 조회결과
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		//한줄정보 Storing
		storingInfo = (Storing) resultMap.get("storingInfo");
		log.info("제품생산내역 수정화면 INFO :: {}", storingInfo);
		model.addAttribute("s", storingInfo);
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산내역 수정");
		
		return "storing/production/production_modify";
	}
	
	/**
	 * 제품생산내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ProductionModify")
	public String modifyProduction(Storing storingInfo) {
		//자재사용내역 수정프로세스
		
		return "redirect:/k1Production";
	}
	
	/**
	 * 제품생산내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ProductionRemove")
	public String removeProduction(Storing storingInfo) {
		//자재사용내역 삭제 프로세스
		return "redirect:/k1Production";
	}
}
