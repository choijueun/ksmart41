package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ShipmentService;

@Controller
public class ShipmentController {
	private final ShipmentService shipmentService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing shipmentInfo; //출하내역 하나
	private List<Storing> shipmentList; //출하내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param shipmentService
	 */
	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	/**
	 * 출하내역 전체목록
	 * @param model
	 */
	@GetMapping("/k1Shipment")
	public String shipmentMain(Model model) {
		//출하내역 전체목록 List<Storing>
		shipmentList = shipmentService.getAllShipmentList(mainBusinessCode);
		model.addAttribute("shipmentList", shipmentList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하");
		
		return "storing/shipment/shipment_list";
	}
	
	/**
	 * 출하내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Shipment/{stockAdjCode}")
	public String shipmentInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Shipment";
		
		//재고조정내역 상세정보 조회결과
		resultMap = shipmentService.getShipmentInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Shipment";
		
		//재고조정내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("shipmentInfo"));
		//재고조정내역 상세정보 List<Storing>
		model.addAttribute("shipmentDetails", resultMap.get("shipmentDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하");
		
		return "storing/shipment/shipment_info";
	}
	
	/**
	 * 출하내역 신규등록
	 * @param model
	 */
	@GetMapping("/k1ShipmentAdd")
	public String addShipment(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보를 model 속성에 추가
			model.addAttribute("s", shipmentService.getStockForStoring(mainBusinessCode, inventoryCode));
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하");
		
		return "storing/shipment/shipment_add";
	}
	
	/**
	 * 출하내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1ShipmentModify/{stockAdjCode}")
	public String modifyShipment(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Shipment";
		
		return "storing/shipment/shipment_modify";
	}
	
	/**
	 * 출하계획 전체조회
	 * @param model
	 */
	@GetMapping("/k1ShipmentPlan")
	public String shipmentPlanMain(Model model) {
		//출하계획 전체목록 List<Storing>
		shipmentList = shipmentService.getShipmentPlanList(mainBusinessCode);
		model.addAttribute("shipmentList", shipmentList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하계획");
		
		return "storing/shipment/shipment_plan_list";
	}
	
	/**
	 * 출하계획 상세정보
	 * @param shipmentPlanCode
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1ShipmentPlan/{shipmentPlanCode}")
	public String shipmentPlanInfo(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(shipmentPlanCode)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 상세정보 조회결과
		resultMap = shipmentService.getShipmentPlanInfo(mainBusinessCode, shipmentPlanCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 한줄정보 Storing
		model.addAttribute("p", resultMap.get("shipPlanInfo"));
		//출하계획 상세정보 List<Storing>
		model.addAttribute("shipPlanDetails", resultMap.get("shipPlanDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하계획");
		
		return "storing/shipment/shipment_plan_info";
	}
	
	/**
	 * 출하계획 신규등록화면 첫페이지
	 * @param model
	 */
	@GetMapping("/k1ShipmentPlanAdd")
	public String addShipmentPlan(Model model) {
		return "storing/shipment/shipment_plan_add";
	}
	
	/**
	 * 출하계획 수정화면 첫페이지
	 * @param shipmentPlanCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ShipmentPlanModify/{shipmentPlanCode}")
	public String modifyShipmentPlan(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(shipmentPlanCode)) return "redirect:/k1ShipmentPlan";
		
		return "storing/shipment/shipment_plan_modify";
	}
	
}
