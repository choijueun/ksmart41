package k1.smart.team.controller.pjh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SlipController {

	@GetMapping("/k1SlipReg")
	public String addSlip() {
		return "slip/slip_register";
	}
	
	@GetMapping("/k1SlipList")
	public String k1getAllSlip() {
		return "slip/slip_list";
	}
	@GetMapping("/k1SlipDetail")
	public String k1getSlip() {
		return "slip/slip_detail";
	}
}
