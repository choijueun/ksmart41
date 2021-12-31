package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.service.pjh.SlipService;

@Controller
@RequestMapping(value="/k1SlipList")
public class SlipController {
	private SlipService slipService;
	private String mainBusinessCode;
	
	public SlipController(SlipService slipService) {
		this.slipService = slipService;
	}
	
	//전표 전체목록
	@GetMapping("")
	public String slipMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<Slip> p_slipList = slipService.getAllPSlipList(mainBusinessCode);
		List<Slip> s_slipList = slipService.getAllSSlipList(mainBusinessCode);
		
		model.addAttribute("title", "전표목록관리");
		model.addAttribute("p_slipList", p_slipList);
		model.addAttribute("s_slipList", s_slipList);
		return "slip/slip_list";
	}
	
	@GetMapping("/{slipCode}")
	//html에서 a 태그 링크 :: P001, S001 ...
	public String slipInfo(
			@PathVariable(value="slipCode", required=false) String slipCode
			,Model model) {
		model.addAttribute("title", "전표관리: 상세정보");
		model.addAttribute("slipCode", slipCode);
		return "slip/slip_detail";	
	}
	
	@GetMapping("/add")
	public String addSlip(Model model) {
		model.addAttribute("title", "전표관리: 등록");
		return "slip/slip_register";
	}
	
	@GetMapping("/modify/{slipCode}")
	public String modifySlip(
			@PathVariable(value="slipCode", required=false) String slipCode
			,Model model) {
		model.addAttribute("title", "전표관리: 수정");
		model.addAttribute("slipCode", slipCode);
		return "slip/slip_modify";
	}
			
			
}	