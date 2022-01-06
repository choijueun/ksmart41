package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.service.cje.MovingService;

@Controller
public class MovingController {
	private MovingService movingService;
	public MovingController(MovingService movingService) {
		this.movingService = movingService;
	}
	
	@GetMapping("/k1Moving")
	public String movingMain(Model model) {
		return "storing/moving/moving_list";
	}
	
	@GetMapping("/k1Moving/{stockAdjCode}")
	public String movingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/moving/moving_info";
	}
	
	@GetMapping("/k1MovingAdd")
	public String addMoving(Model model) {
		return "storing/moving/moving_add";
	}
	
	@GetMapping("/k1MovingModify/{stockAdjCode}")
	public String modifyMoving(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/moving/moving_modify";
	}
}
