package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class MaterialUseController {
	private final StoringService storingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Stock stockInfo; //재고정보
	private Storing materialUseInfo; //자재사용내역 정보
	private List<Storing> materialUseList; //자재사용내역 배열
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
	public String materialUseMain(Model model) {
		//자재사용내역 전체목록 List<Storing>
		materialUseList = storingService.getAllMaterialUseList(mainBusinessCode);
		log.info("자재사용내역 LIST :: {}", materialUseList);
		model.addAttribute("materialUseList", materialUseList);
		
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
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		//자재사용내역 상세정보 조회결과
		resultMap = storingService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		//자재사용내역 한줄정보 Storing
		materialUseInfo = (Storing) resultMap.get("materialUseInfo");
		log.info("자재사용내역 INFO :: {}", materialUseInfo);
		model.addAttribute("s", materialUseInfo);
		//자재사용내역 상세정보 List<Storing>
		model.addAttribute("materialUseDetails", resultMap.get("materialUseDetails"));

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
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring(mainBusinessCode, inventoryCode);
			log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 등록");
		
		return "storing/material_use/material_use_add";
	}
	
	/**
	 * 자재사용내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1MaterialUseModify/{stockAdjCode}")
	public String modifyMaterialUse(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		//자재사용내역 상세정보 조회결과
		resultMap = storingService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";

		//자재사용내역 한줄정보 Storing
		materialUseInfo = (Storing) resultMap.get("materialUseInfo");
		log.info("자재사용내역 INFO :: {}", materialUseInfo);
		model.addAttribute("s", materialUseInfo);
		//자재사용내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("materialUseDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 수정");
		
		return "storing/material_use/material_use_modify";
	}
}
