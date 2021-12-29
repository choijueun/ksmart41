package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.ShipmentService;

@Controller
@RequestMapping(value="/k1Shipment")
public class ShipmentController {
	private ShipmentService shipmentService;
	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	//출하내역 전체목록
	@GetMapping("")
	public String shipmentMain(Model model) {
		return "storing/shipment/shipment_list";
	}
	
	//출하내역 상세정보
	@GetMapping("/{stockAdjCode}")
	public String shipmentInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/shipment/shipment_info";
	}
	
	//출하내역 신규등록
	@GetMapping("/add")
	public String addShipment(Model model) {
		return "storing/shipment/shipment_add";
	}
	
	//출하내역 수정
	@GetMapping("/modify/{shipmentPlanCode}")
	public String modifyShipment(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/shipment_modify";
	}
	
	//출하계획 전체조회
	@GetMapping("/plan")
	public String shipmentPlanMain(Model model) {
		return "storing/shipment/shipment_plan_list";
	}
	
	//출하계획 상세정보
	@GetMapping("/plan/{shipmentPlanCode}")
	public String shipmentPlanInfo(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/return_request_info";
	}
	
	//출하계획 신규등록
	@GetMapping("/addPlan")
	public String addShipmentPlan(Model model) {
		return "storing/shipment/shipment_plan_add";
	}
	
	//출하계획 수정
	@GetMapping("/modifyPlan/{shipmentPlanCode}")
	public String modifyShipmentPlan(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/shipment_plan_modify";
	}
	
}
