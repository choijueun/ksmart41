package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.DefectService;

@Controller
@RequestMapping(value="/k1Defect")
public class DefectController {
	private DefectService defectService;
	public DefectController(DefectService defectService) {
		this.defectService = defectService;
	}
	
	//불량관리 첫페이지 (전체목록조회)
	@GetMapping("")
	public String defectMain(Model model) {
		model.addAttribute("title", "불량처리");
		return "storing/defect/defect_list";
	}
	
	//불량처리내역 상세정보 조회
	@GetMapping("/{stockAdjCode}")
	public String defectInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "불량처리");
		return "storing/defect/defect_info";
	}
	
	@GetMapping("/add")
	public String addDefect(Model model) {
		model.addAttribute("title", "불량처리내역추가");
		return "storing/defect/defect_add";
	}
	
	//불량처리내역 수정
	@GetMapping("/modify/{stockAdjCode}")
	public String modifyDefect(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "불량처리 수정");
		return "storing/defect/defect_modify";
	}

}
