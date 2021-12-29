package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}	