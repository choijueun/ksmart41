package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.MaterialUseService;

@Controller
public class MaterialUseController {
	private MaterialUseService materialUseService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing materialUseInfo; //출하내역 하나
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
		
		materialUseList = materialUseService.getAllMaterialUseList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "자재사용");
		model.addAttribute("materialUseList", materialUseList);
		
		return "storing/material_use/material_use_list";
	}
	
	/**
	 * 자재사용내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1MaterialUse/{stockAdjCode}")
	public String materialUseInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		
		resultMap = materialUseService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1MaterialUse";
		
		materialUseInfo = (Storing) resultMap.get("materialUseInfo");
		materialUseList = (List<Storing>) resultMap.get("materialUseDetails");
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "출하");
		model.addAttribute("materialUseInfo", materialUseInfo);
		model.addAttribute("materialUseDetails", materialUseList);
		
		return "storing/material_use/material_use_info";
	}
	
	@GetMapping("/k1MaterialUseAdd")
	public String addMaterialUse(Model model) {
		return "storing/material_use/material_use_add";
	}
	
	@GetMapping("/k1MaterialUseModify/{stockAdjCode}")
	public String modifyMaterialUse(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/material_use/material_use_modify";
	}
}
