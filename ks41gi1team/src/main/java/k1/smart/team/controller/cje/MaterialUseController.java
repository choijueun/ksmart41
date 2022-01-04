package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.service.cje.MaterialUseService;

@Controller
public class MaterialUseController {
	private MaterialUseService materialUseService;
	public MaterialUseController(MaterialUseService materialUseService) {
		this.materialUseService = materialUseService;
	}
	
	@GetMapping("/k1MaterialUse")
	public String materialUseMain(Model model) {
		return "storing/material_use/material_use_list";
	}
	
	@GetMapping("/k1MaterialUse/{stockAdjCode}")
	public String materialUseInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
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
