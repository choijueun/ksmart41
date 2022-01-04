package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.DefectService;

@Controller
public class DefectController {
	private DefectService defectService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private List<Storing> defectList; //불량처리내역 배열
	private Storing defectInfo; //불량처리내역 정보
	public DefectController(DefectService defectService) {
		this.defectService = defectService;
	}
	
	//불량관리 첫페이지 (전체목록조회)
	@GetMapping("/k1Defect")
	public String defectMain(Model model) {
		defectList = defectService.getAllDefectList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "불량처리");
		model.addAttribute("defectList", defectList);
		
		return "storing/defect/defect_list";
	}
	
	//불량처리내역 상세정보 조회
	@GetMapping("/k1Defect/{stockAdjCode}")
	public String defectInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "불량처리");
		return "storing/defect/defect_info";
	}
	
	@GetMapping("/k1DefectAdd")
	public String addDefect(Model model) {
		model.addAttribute("title", "불량처리내역추가");
		return "storing/defect/defect_add";
	}
	
	//불량처리내역 수정
	@GetMapping("/k1DefectModify/{stockAdjCode}")
	public String modifyDefect(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		model.addAttribute("title", "불량처리 수정");
		return "storing/defect/defect_modify";
	}

}
