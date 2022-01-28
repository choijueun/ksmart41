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
public class MaterialUseController {
	private final StoringService storingService;
	private Stock stockInfo; //재고정보
	private Storing storingInfo; //자재사용내역 정보
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(MaterialUseController.class);
	
	/**
	 * 생성자 메서드
	 * @param materialUseService
	 */
	public MaterialUseController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 자재사용내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1MaterialUse")
	public String materialUseMain(Model model, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//사업장대표코드
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockReasonCode", 2);
		
		//전체목록 List<Storing>
		model.addAttribute("storingList", storingService.getStoringList(paramMap));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용");
		
		return "storing/material_use/material_use_list";
	}
	
	/**
	 * 자재사용내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1MaterialUse/{stockAdjCode}")
	public String materialUseInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 2);
		//상세정보 조회
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		//한줄정보 Storing
		model.addAttribute("s", resultMap.get("storingInfo"));
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));

		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용");
		
		return "storing/material_use/material_use_info";
	}
	
	/**
	 * 자재사용내역 신규등록화면 (특정재고)
	 * @param inventoryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1MaterialUseAdd")
	public String addMaterialUse(
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
		model.addAttribute("SectionLocation", "자재사용내역 등록");
		
		return "storing/material_use/material_use_add";
	}
	
	/**
	 * 자재사용내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MaterialUseAdd")
	public String addMaterialUser(Storing storingInfo) {
		//자재사용내역 등록 프로세스
		
		return "redirect:/k1MaterialUse";
	}
	
	/**
	 * 자재사용내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1MaterialUseModify/{stockAdjCode}")
	public String modifyMaterialUse(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model, HttpSession session) {
		//NULL체크
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		//map생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		paramMap.put("stockAdjCode", stockAdjCode);
		paramMap.put("stockReasonCode", 2);
		//상세정보 조회결과
		resultMap = storingService.getStoringInfo(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		//한줄정보 Storing
		storingInfo = (Storing) resultMap.get("storingInfo");
		log.info("자재사용내역 수정화면 INFO :: {}", storingInfo);
		model.addAttribute("s", storingInfo);
		//상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("storingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 수정");
		
		return "storing/material_use/material_use_modify";
	}
	
	/**
	 * 자재사용내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MaterialUseModify")
	public String modifyMaterialUser(Storing storingInfo) {
		//자재사용내역 수정프로세스
		
		return "redirect:/k1MaterialUse";
	}
	
	/**
	 * 자재사용내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MaterialUseRemove")
	public String removeMaterialUser(Storing storingInfo) {
		//자재사용내역 삭제 프로세스
		return "redirect:/k1MaterialUse";
	}
}
