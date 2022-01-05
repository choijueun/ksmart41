package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModalController {
	@GetMapping("/storingModal")
	public String storingModal(Model model) {
		
		model.addAttribute("title", "물류이동");
		
		return "storing/storingModal";
	}
}
