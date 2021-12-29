package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.MovingService;

@Controller
@RequestMapping(value="/k1Moving")
public class MovingController {
	private MovingService movingService;
	public MovingController(MovingService movingService) {
		this.movingService = movingService;
	}
	
	@GetMapping("")
	public String movingMain(Model model) {
		return "storing/moving/moving_list";
	}
	
	@GetMapping("/{stockAdjCode}")
	public String movingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/moving/moving_info";
	}
	
	@GetMapping("/add")
	public String addMoving(Model model) {
		return "storing/moving/moving_add";
	}
	
	@GetMapping("/modify/{stockAdjCode}")
	public String modifyMoving(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/moving/moving_modify";
	}
}
