package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ShipmentService;

@Controller
public class ShipmentController {
	private ShipmentService shipmentService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing shipmentInfo; //출하내역 하나
	private List<Storing> shipmentList; //출하내역 배열
	private Map<String, Object> resultMap;
	
	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	/**
	 * 출하내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Shipment")
	public String shipmentMain(Model model) {
		shipmentList = shipmentService.getAllShipmentList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "제품출하");
		model.addAttribute("shipmentList", shipmentList);
		
		return "storing/shipment/shipment_list";
	}
	
	/**
	 * 출하내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Shipment/{stockAdjCode}")
	public String shipmentInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Shipment";
		
		resultMap = shipmentService.getShipmentInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Shipment";
		
		shipmentInfo = (Storing) resultMap.get("shipmentInfo");
		shipmentList = (List<Storing>) resultMap.get("shipmentDetails");
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "제품출하");
		model.addAttribute("shipmentInfo", shipmentInfo);
		model.addAttribute("shipmentDetails", shipmentList);
		
		return "storing/shipment/shipment_info";
	}
	
	//출하내역 신규등록
	@GetMapping("/k1ShipmentAdd")
	public String addShipment(Model model) {
		return "storing/shipment/shipment_add";
	}
	
	//출하내역 수정
	@GetMapping("/k1ShipmentModify/{shipmentPlanCode}")
	public String modifyShipment(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/shipment_modify";
	}
	
	//출하계획 전체조회
	@GetMapping("/k1ShipmentPlan")
	public String shipmentPlanMain(Model model) {
		return "storing/shipment/shipment_plan_list";
	}
	
	//출하계획 상세정보
	@GetMapping("/k1ShipmentPlan/{shipmentPlanCode}")
	public String shipmentPlanInfo(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/return_request_info";
	}
	
	//출하계획 신규등록
	@GetMapping("/k1ShipmentPlanAdd")
	public String addShipmentPlan(Model model) {
		return "storing/shipment/shipment_plan_add";
	}
	
	//출하계획 수정
	@GetMapping("/k1ShipmentPlanModify/{shipmentPlanCode}")
	public String modifyShipmentPlan(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/shipment_plan_modify";
	}
	
}
