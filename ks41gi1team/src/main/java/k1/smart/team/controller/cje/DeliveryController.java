package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.service.cje.DeliveryService;

@Controller
public class DeliveryController {
	private DeliveryService delivryService;
	public DeliveryController(DeliveryService delivryService) {
		this.delivryService = delivryService;
	}

	@GetMapping("/k1Delivery")
	public String deliveryMain(Model model) {
		model.addAttribute("title", "운송요청");
		return "storing/delivry/delivery_list";
	}
	
	@GetMapping("/k1Delivery/{deliveryCode}")
	public String deliveryInfo(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		model.addAttribute("title", "운송요청: 상세정보");
		model.addAttribute("deliveryCode", deliveryCode);
		return "storing/delivry/delivery_info";
	}
	
	@GetMapping("/k1DeliveryAdd")
	public String addDelivery(Model model) {
		model.addAttribute("title", "운송요청: 등록");
		return "storing/delivry/delivery_add";
	}
	
	@GetMapping("/k1DeliveryModify/{deliveryCode}")
	public String modifyDelivery(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		model.addAttribute("title", "운송요청: 수정");
		model.addAttribute("deliveryCode", deliveryCode);
		return "storing/delivry/delivery_modify";
	}
}
