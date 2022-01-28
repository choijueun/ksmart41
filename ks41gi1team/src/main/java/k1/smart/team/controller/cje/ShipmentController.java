package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class ShipmentController {
	private final StoringService storingService;
	private Map<String, Object> resultMap;
	private Stock stockInfo; //재고정보
	private Storing shipmentInfo; //출하내역
	private List<Storing> shipmentList; //출하내역 배열
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private static final Logger log = LoggerFactory.getLogger(ShipmentController.class);
	
	/**
	 * 생성자 메서드
	 * @param shipmentService
	 */
	public ShipmentController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 출하내역 전체목록
	 * @param model
	 */
	@GetMapping("/k1Shipment")
	public String shipmentMain(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		paramMap.put("stockReasonCode", 5);
		//출하내역 전체목록 List<Storing>
		resultMap = storingService.getAllStoringList(paramMap);
		model.addAttribute("shipmentList", resultMap.get("storingList"));
		
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
		
		//출하내역 상세정보 조회결과
		resultMap = storingService.getShipmentInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Shipment";
		
		//출하내역 한줄정보 Storing
		shipmentInfo = (Storing) resultMap.get("shipmentInfo");
		log.info("출하내역 INFO :: {}", shipmentInfo);
		model.addAttribute("s", shipmentInfo);
		//출하내역 상세정보 List<Storing>
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
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring(mainBusinessCode, inventoryCode);
			log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품출하내역 등록");
		
		return "storing/shipment/shipment_add";
	}
	
	/**
	 * 출하내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentAdd")
	public String addShipment(Storing storingInfo) {
		//출하내역 등록 프로세스
		
		return "redirect:/k1Shipment";
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
		
		//출하내역 상세정보 조회결과
		resultMap = storingService.getShipmentInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Shipment";
		
		//출하내역 한줄정보 Storing
		shipmentInfo = (Storing) resultMap.get("shipmentInfo");
		log.info("창고이동내역 INFO :: {}", shipmentInfo);
		model.addAttribute("s", shipmentInfo);
		//출하내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("shipmentDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "출하내역 수정");

		
		return "storing/shipment/shipment_modify";
	}
	
	/**
	 * 출하내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentModify")
	public String modifyShipment(Storing storingInfo) {
		//출하내역 수정프로세스
		
		return "redirect:/k1Shipment";
	}
	
	/**
	 * 출하내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentRemove")
	public String removeShipment(Storing storingInfo) {
		//출하내역 삭제 프로세스
		return "redirect:/k1Shipment";
	}
	
	
	
	
	/*
	 * *******************************
	 *				출하계획 
	 * *******************************
	 */
	
	/**
	 * 출하계획 전체조회
	 * @param model
	 */
	@GetMapping("/k1ShipmentPlan")
	public String shipmentPlanMain(Model model) {
		//출하계획 전체목록 List<Storing>
		shipmentList = storingService.getShipmentPlanList(mainBusinessCode);
		log.info("출하계획 LIST :: {}", shipmentList);
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
	@GetMapping("/k1ShipmentPlan/{shipmentPlanCode}")
	public String shipmentPlanInfo(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(shipmentPlanCode)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 상세정보 조회결과
		resultMap = storingService.getShipmentPlanInfo(mainBusinessCode, shipmentPlanCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 한줄정보 Storing
		shipmentInfo = (Storing) resultMap.get("shipPlanInfo");
		log.info("출하계획 INFO :: {}", shipmentInfo);
		model.addAttribute("p", shipmentInfo);
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
	 * 출하계획 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentPlanAdd")
	public String addShipmentPlan(Storing storingInfo) {
		//출하계획 등록 프로세스
		
		return "redirect:/k1ShipmentPlan";
	}
	
	/**
	 * 출하계획 수정화면 첫페이지
	 * @param shipmentPlanCode
	 * @param model
	 */
	@GetMapping("/k1ShipmentPlanModify/{shipmentPlanCode}")
	public String modifyShipmentPlan(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(shipmentPlanCode)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 상세정보 조회결과
		resultMap = storingService.getShipmentPlanInfo(mainBusinessCode, shipmentPlanCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1ShipmentPlan";
		
		//출하계획 한줄정보 Storing
		shipmentInfo = (Storing) resultMap.get("shipPlanInfo");
		log.info("창고이동내역 INFO :: {}", shipmentInfo);
		model.addAttribute("s", shipmentInfo);
		//출하계획 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("shipPlanDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "출하계획 수정");

		return "storing/shipment/shipment_plan_modify";
	}
	
	/**
	 * 출하계획 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentPlanModify")
	public String modifyShipmentPlan(Storing storingInfo) {
		//출하계획 수정프로세스
		
		return "redirect:/k1ShipmentPlan";
	}
	
	/**
	 * 출하계획 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1ShipmentPlanRemove")
	public String removeShipmentPlan(Storing storingInfo) {
		//출하계획 삭제 프로세스
		return "redirect:/k1ShipmentPlan";
	}
}
