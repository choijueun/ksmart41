package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.TotalAc;
import k1.smart.team.service.pjh.TotalAcService;

@Controller
@RequestMapping(value = "/k1TotalAc")
public class TotalAcController {
	private TotalAcService totalAcService;
	private String mainBusinessCode;
	
	public TotalAcController(TotalAcService totalAcService) {
		this.totalAcService = totalAcService;
	}
	
	@GetMapping("")
	public String totalAcMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<TotalAc> totalAcList = totalAcService.getTotalAcList(mainBusinessCode);
		
		model.addAttribute("title","통합회계관리");
		model.addAttribute("totalAcList",totalAcList);
		return "totalAc/totalAc_list";
	}
	
	@GetMapping("/{totalAccountCode}")
	public String totalAcInfo(
			@PathVariable(value = "totalAccountCode", required = false) String totalAccountCode
			,Model model) {
		model.addAttribute("title", "통합회계관리: 상세정보");
		model.addAttribute("totalAccountCode", totalAccountCode);
		return "totalAc/totalAc_detail";
	}
	
	@GetMapping("/add")
	public String addTotalAc(Model model) {
		model.addAttribute("title", "통합회계관리: 등록");
		return "totalAc/totalAc_register";
	}
	
	@GetMapping("/modify/{totalAccountCode}")
	public String modifyTotalAc(
			@PathVariable(value = "totalAccountCode", required = false) String totalAccountCode
			,Model model) {
		model.addAttribute("title", "통합회계관리: 수정");
		model.addAttribute("totalAccountCode", totalAccountCode);
		return "totalAc/totalAc_modify";
	}
	
}
