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
public class WarehousingController {
	private final StoringService storingService;
	private String mainBusinessCode; //사업장대표코드
	private Stock stockInfo; //재고정보
	private Storing storingInfo; //자재입고내역
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(WarehousingController.class);
	
	/**
	 * 생성자 메서드
	 * @param warehousingService
	 */
	public WarehousingController(StoringService storingService) {
		this.storingService = storingService;
	}

	/**
	 * 입고내역 전체목록 조회
	 * @param model
	 */
	@GetMapping("/k1Warehousing")
	public String warehousingMain(Model model, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//사업장대표코드
		mainBusinessCode = (String) session.getAttribute("MAINBUSINESSCODE");
		paramMap.put("mainBusinessCode", mainBusinessCode);
		paramMap.put("stockReasonCode", 1);
		
		//전체목록 List<Storing>
		model.addAttribute("storingList", storingService.getStoringList(paramMap));
		
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고");
		
		return "storing/warehousing/warehousing_list";
	}
	
	/**
	 * 입고내역 상세정보 조회
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Warehousing/{stockAdjCode}")
	public String warehousingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Warehousing";
		//사업장대표코드
		mainBusinessCode = (String) session.getAttribute("MAINBUSINESSCODE");
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 1);
		//상세정보 조회
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//한줄정보 Storing
		model.addAttribute("s", resultMap.get("storingInfo"));
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고");
		
		return "storing/warehousing/warehousing_info";
	}
	
	/**
	 * 입고내역 신규등록화면 (+특정재고)
	 * @param model
	 */
	@GetMapping("/k1WarehousingAdd")
	public String addWarehousing(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model, HttpSession session) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring((String) session.getAttribute("MAINBUSINESSCODE"), inventoryCode);
			//log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 등록");
		
		return "storing/warehousing/warehousing_add";
	}
	
	/**
	 * 입고내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1WarehousingAdd")
	public String addWarehousing(Storing storingInfo, HttpSession session) {
		//상세정보(품목) 존재하지 않을 경우
		if(CommonUtils.isEmpty(storingInfo.getS())) return "redirect:/k1WarehousingAdd";
		//사업장대표코드
		mainBusinessCode = (String) session.getAttribute("MAINBUSINESSCODE");
		storingInfo.setMainBusinessCode(mainBusinessCode);
		//물류이동사유Setting
		storingInfo.setStockReasonCode(1);
		log.info("물류이동한줄내역  등록 :: {}",storingInfo);
		
		//등록 process
		if(storingService.addStoringInfo(storingInfo)) {
			//성공
			return "redirect:/k1Warehousing";
		}else {
			//실패
			return "redirect:/k1WarehousingAdd";
		}
	}
	
	/**
	 * 입고내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1WarehousingModify/{stockAdjCode}")
	public String modifyWarehousing(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Warehousing";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		mainBusinessCode = (String) session.getAttribute("MAINBUSINESSCODE");
		paramMap.put("mainBusinessCode", mainBusinessCode);
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 1);
		//상세정보 조회결과
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//한줄정보 Storing
		storingInfo = (Storing) resultMap.get("storingInfo");
		log.info("입고내역 수정화면 INFO :: {}", storingInfo);
		model.addAttribute("s", storingInfo);
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 수정");
		
		return "storing/warehousing/warehousing_modify";
	}
	
	/**
	 * 입고내역 수정 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1WarehousingModify")
	public String modifyWarehousing(Storing storingInfo) {
		log.info("수정할 storingInfo :: {}", storingInfo);
		//수정 프로세스 진행
		
		return "redirect:/k1Warehousing";
	}
}
