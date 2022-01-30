package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.DeliveryService;

@Controller
public class DeliveryController {
	private final DeliveryService deliveryService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드 임시지정
	private Delivery deliveryInfo; //운송요청내역 정보
	private List<Delivery> deliveryList; //운송요청정보 배열
	private Map<String,Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);
	
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
		//운송내역 전체목록 List<Delivery> 반환 및 model 속성 추가
		deliveryList = deliveryService.getAllDeliveryList(mainBusinessCode);
		log.info("운송요청내역 LIST :: {}", deliveryList);
		model.addAttribute("deliveryList", deliveryList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청");
		
		return "storing/delivery/delivery_list";
	}
	
	/**
	 * 운송요청내역 상세조회
	 * @param deliveryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Delivery/{deliveryCode}")
	public String deliveryInfo(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(deliveryCode)) return "redirect:/k1Delivery";
		
		//운송요청내역 상세정보 조회결과
		resultMap = deliveryService.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Delivery";
		
		//운송요청정보
		deliveryInfo = (Delivery) resultMap.get("deliveryInfo");
		log.info("운송요청 INFO :: {}", deliveryInfo);
		model.addAttribute("d", resultMap.get("deliveryInfo"));
		//출하예정정보
		model.addAttribute("shipPlanDetails", resultMap.get("shipPlanDetails"));
		//반품요청정보
		model.addAttribute("returnRegDetails", resultMap.get("returnRegDetails"));
		
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청정보");
		
		return "storing/delivery/delivery_info";
	}
	
	/**
	 * 운송요청내역 신규등록화면
	 * @param model
	 * @return
	 */
	@GetMapping("/k1DeliveryAdd")
	public String addDelivery(Model model) {
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청 등록");
		
		return "storing/delivery/delivery_add";
	}
	
	/**
	 * 운송요청내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1DeliveryAdd")
	public String addDelivery(Storing storingInfo) {
		//운송요청내역 등록 프로세스
		log.info("PARAMETER :: {}", storingInfo);
		
		return "redirect:/k1Delivery";
	}
	
	/**
	 * 운송요청내역 수정화면
	 * @param deliveryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1DeliveryModify/{deliveryCode}")
	public String modifyDelivery(
			@PathVariable(value="deliveryCode", required=false) String deliveryCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(deliveryCode)) return "redirect:/k1Delivery";
		
		//운송요청내역 상세정보 조회결과
		resultMap = deliveryService.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Delivery";
		
		//운송요청정보
		model.addAttribute("d", resultMap.get("deliveryInfo"));
			
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "운송요청 수정");
		
		return "storing/delivery/delivery_modify";
	}
	
	/**
	 * 운송요청내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1DeliveryModify")
	public String modifyDelivery(Storing storingInfo) {
		//운송요청내역 수정프로세스
		
		return "redirect:/k1Delivery";
	}
	
	/**
	 * 운송요청내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1DeliveryRemove")
	public String removeDelivery(Storing storingInfo) {
		//운송요청내역 삭제 프로세스
		
		return "redirect:/k1Delivery";
	}
}
