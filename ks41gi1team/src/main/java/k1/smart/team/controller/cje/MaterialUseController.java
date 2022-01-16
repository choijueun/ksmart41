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
import k1.smart.team.service.cje.MaterialUseService;

@Controller
public class MaterialUseController {
	private final MaterialUseService materialUseService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private List<Storing> materialUseList; //출하내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param materialUseService
	 */
	public MaterialUseController(MaterialUseService materialUseService) {
		this.materialUseService = materialUseService;
	}
	
	/**
	 * 자재사용내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1MaterialUse")
	public String materialUseMain(Model model) {
		//자재사용내역 전체목록 List<Storing>
		materialUseList = materialUseService.getAllMaterialUseList(mainBusinessCode);
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
		resultMap = materialUseService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		//자재사용내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("materialUseInfo"));
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
			//해당 재고 정보를 model 속성에 추가
			model.addAttribute("s", materialUseService.getStockForStoring(mainBusinessCode, inventoryCode));
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 등록");
		
		return "storing/material_use/material_use_add";
	}
	
	@GetMapping("/k1MaterialUseModify/{stockAdjCode}")
	public String modifyMaterialUse(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		//자재사용내역 상세정보 조회결과
		resultMap = materialUseService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";

		//자재사용내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("materialUseInfo"));
		//자재사용내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("materialUseDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 수정");
		
		return "storing/material_use/material_use_modify";
	}
}
