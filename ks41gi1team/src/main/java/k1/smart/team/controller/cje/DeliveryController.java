package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.DelivryService;

@Controller
@RequestMapping(value="/k1Delivery")
public class DeliveryController {
	private DelivryService delivryService;
	public DeliveryController(DelivryService delivryService) {
		this.delivryService = delivryService;
	}

	@GetMapping("")
	public String deliveryMain(Model model) {
		model.addAttribute("title", "운송요청");
		return "storing/delivry/delivery_list";
	}
	
	@GetMapping("/{deliveryCode}")
	public String deliveryInfo(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		model.addAttribute("title", "운송요청: 상세정보");
		model.addAttribute("deliveryCode", deliveryCode);
		return "storing/delivry/delivery_info";
	}
	
	@GetMapping("/add")
	public String addDelivery(Model model) {
		model.addAttribute("title", "운송요청: 등록");
		return "storing/delivry/delivery_add";
	}
	
	@GetMapping("/modify/{deliveryCode}")
	public String modifyDelivery(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		model.addAttribute("title", "운송요청: 수정");
		model.addAttribute("deliveryCode", deliveryCode);
		return "storing/delivry/delivery_modify";
	}
}
