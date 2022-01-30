package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
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
public class ReturnController {
	private final StoringService storingService;
	private Map<String, Object> resultMap;
	private Stock stockInfo; //재고정보
	private Storing storingInfo; //출하내역
	private List<Storing> returnList; //반품처리내역 배열
	private static final Logger log = LoggerFactory.getLogger(ReturnController.class);
	
	/**
	 * 생성자 메서드
	 * @param returnService
	 */
	public ReturnController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 반품내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Return")
	public String returnMain(Model model, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//사업장대표코드
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockReasonCode", 7);
		
		//전체목록 List<Storing>
		model.addAttribute("storingList", storingService.getStoringList(paramMap));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리");
		
		return "storing/return/return_list";
	}
	
	/**
	 * 반품내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Return/{stockAdjCode}")
	public String returnInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Return";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 7);
		//상세정보 조회
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Return";
		
		//한줄정보 Storing
		model.addAttribute("s", resultMap.get("storingInfo"));
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리");
		
		return "storing/return/return_info";
	}
	
	/**
	 * 반품내역 신규등록
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1ReturnAdd")
	public String addReturn(
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
		model.addAttribute("SectionLocation", "반품처리내역 등록");
		
		return "storing/return/return_add";
	}
	
	/**
	 * 반품내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnAdd")
	public String addReturn(Storing storingInfo) {
		//반품내역 등록 프로세스
		
		return "redirect:/k1Return";
	}
	
	/**
	 * 반품내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1ReturnModify/{stockAdjCode}")
	public String modifyReturn(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Return";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 7);
		//상세정보 조회결과
		resultMap = storingService.getStoringInfo(paramMap);
		//여기서...redirect됐다: 왜?
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Return";
		
		//한줄정보 Storing
		storingInfo = (Storing) resultMap.get("storingInfo");
		log.info("반품내역 수정화면 INFO :: {}", storingInfo);
		model.addAttribute("s", storingInfo);
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리내역 수정");
		
		return "storing/return/return_modify";
	}
	
	/**
	 * 반품내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnModify")
	public String modifyReturn(Storing storingInfo) {
		//반품내역 수정프로세스
		
		return "redirect:/k1Return";
	}
	
	/**
	 * 반품내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnRemove")
	public String removeReturn(Storing storingInfo) {
		//반품내역 삭제 프로세스
		return "redirect:/k1Return";
	}
	
	
	/*
	 * *******************************
	 *				반품요청
	 * *******************************
	 */
	
	/**
	 * 반품요청내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnReg")
	public String returnRegMain(Model model, HttpSession session) {
		//반품요청내역 전체목록 List<Storing>
		returnList = storingService.getReturnRegList((String) session.getAttribute("MAINBUSINESSCODE"));
		log.info("반품요청내역 LIST :: {}", returnList);
		model.addAttribute("returnRegList", returnList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품요청");
		
		return "storing/return/return_request_list";
	}
	
	/**
	 * 반품요청내역 상세정보
	 * @param returnRegCode
	 * @param model
	 */
	@GetMapping("/k1ReturnReg/{returnRegCode}")
	public String returnRegInfo(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(returnRegCode)) return "redirect:/k1ReturnReg";
		//반품요청내역 상세정보 조회결과
		resultMap = storingService.getReturnRegInfo(returnRegCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1ReturnReg";

		//반품요청내역 한줄정보 Storing
		storingInfo = (Storing) resultMap.get("returnRegInfo");
		log.info("반품요청내역 INFO :: {}", storingInfo);
		model.addAttribute("r", storingInfo);
		//반품요청내역 상세정보 List<Storing>
		model.addAttribute("returnRegDetails", resultMap.get("returnRegDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품요청정보");
		
		return "storing/return/return_request_info";
	}

	/**
	 * 반품요청내역 신규등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnRegAdd")
	public String addReturnReg(Model model) {
		
		return "storing/return/return_request_add";
	}
	
	/**
	 * 반품내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnRegAdd")
	public String addReturnReg(Storing storingInfo) {
		//반품내역 등록 프로세스
		
		return "redirect:/k1ReturnReg";
	}
	
	/**
	 * 반품요청내역 수정
	 * @param returnRegCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnRegModify/{returnRegCode}")
	public String modifyReturnReg(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(returnRegCode)) return "redirect:/k1ReturnReg";

		return "storing/return/return_request_modify";
	}
	
	/**
	 * 반품요청내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnRegModify")
	public String modifyReturnReg(Storing storingInfo) {
		//반품요청내역 수정프로세스
		
		return "redirect:/k1ReturnReg";
	}
	
	/**
	 * 반품요청내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ReturnRegRemove")
	public String removeReturnReg(Storing storingInfo) {
		//반품요청내역 삭제 프로세스
		
		return "redirect:/k1ReturnReg";
	}
}
