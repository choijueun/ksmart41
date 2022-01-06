package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.service.cje.DeliveryService;

@Controller
public class DeliveryController {
	private DeliveryService deliveryService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드 임시지정
	private Delivery deliveryInfo; //운송요청정보
	private List<Delivery> deliveryList; //운송요청정보 배열
	private Map<String,Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param delivryService
	 */
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	/**
	 * 운송요청내역 전체조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Delivery")
	public String deliveryMain(Model model) {
		deliveryList = deliveryService.getAllDeliveryList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청");
		model.addAttribute("deliveryList", deliveryList);
		
		return "storing/delivry/delivery_list";
	}
	
	@GetMapping("/k1Delivery/{deliveryCode}")
	public String deliveryInfo(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		if(deliveryCode == null || "".equals(deliveryCode)) return "redirect:/k1Delivery";
		
		resultMap = deliveryService.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(resultMap == null) return "redirect:/k1Delivery";
		
		//운송내역정보
		deliveryInfo = (Delivery) resultMap.get("deliveryInfo");
		//출하예정정보
		
		//반품요청정보
		
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청 상세정보");
		model.addAttribute("deliveryInfo", deliveryInfo);
		
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
