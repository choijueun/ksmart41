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
	private MaterialUseService materialUseService;
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
		
		materialUseList = materialUseService.getAllMaterialUseList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
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
	@GetMapping("/k1MaterialUse/{stockAdjCode}")
	public String materialUseInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		resultMap = materialUseService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용");
		model.addAttribute("s", resultMap.get("materialUseInfo"));
		model.addAttribute("materialUseDetails", resultMap.get("materialUseDetails"));
		
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
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 등록");
		
		if(CommonUtils.isEmpty(inventoryCode)) return "storing/material_use/material_use_add";
		
		model.addAttribute("s", materialUseService.getStockForStoring(mainBusinessCode, inventoryCode));
		
		return "storing/material_use/material_use_add";
	}
	
	@GetMapping("/k1MaterialUseModify/{stockAdjCode}")
	public String modifyMaterialUse(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1MaterialUse";
		
		resultMap = materialUseService.getMaterialUseInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1MaterialUse";
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재사용내역 수정");
		model.addAttribute("s", resultMap.get("materialUseInfo"));
		model.addAttribute("details", resultMap.get("materialUseDetails"));
		
		return "storing/material_use/material_use_modify";
	}
}
