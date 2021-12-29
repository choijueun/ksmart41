package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.StoringService;

@Controller
@RequestMapping(value="/k1Storing")
public class StoringController {
	private StoringService storingService;
	
	public StoringController(StoringService storingService) {
		this.storingService = storingService;
	}

	@GetMapping("")
	public String storingMain(Model model) {
		model.addAttribute("title", "물류관리");
		return "storing/storing_history";
	}
}
