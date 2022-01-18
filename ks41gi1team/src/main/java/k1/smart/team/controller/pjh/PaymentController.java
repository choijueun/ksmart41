package k1.smart.team.controller.pjh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.HistoryPayment;
import k1.smart.team.dto.pjh.CancelPayment;
import k1.smart.team.dto.pjh.PlanPayment;
import k1.smart.team.service.pjh.PaymentService;

@Controller
@RequestMapping(value = "/k1PaymentList")
public class PaymentController {
	private PaymentService pService;
	private String mainBusinessCode;
	private PlanPayment planPaymentInfo;
	private CancelPayment cancelPaymentInfo;
	private HistoryPayment historyPaymentInfo;
	private List<PlanPayment> planPaymentInfoList; 
	private List<HistoryPayment> historyPaymentInfoList; 
	private Map<String,Object> resultMap;
	
	public PaymentController(PaymentService pService) {
		this.pService = pService;
	}
	
	//결제관리 전체조회
	@GetMapping("")
	public String HistoryPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		System.out.println("Controller: "+mainBusinessCode);
		List<HistoryPayment> historyPayment = pService.getHistoryPaymentList(mainBusinessCode);
		List<CancelPayment> cancelPayment = pService.getCancelPaymentList(mainBusinessCode);
		List<PlanPayment> planPayment = pService.getPlanPaymentList(mainBusinessCode);
		System.out.println("PaymentController.java 결제관리 전체조회 :: "+historyPayment);
		
		model.addAttribute("title","결제관리");
		model.addAttribute("historyPayment", historyPayment);
		model.addAttribute("planPayment", planPayment);
		model.addAttribute("cancelPayment", cancelPayment);
		
		return "payment/payment_list";
	}
	
	//결제관리 상세
	@SuppressWarnings("unchecked")
	@GetMapping("history/{payHistoryCode}")
	public String historyPaymentInfo(
			@PathVariable(value="payHistoryCode", required=false) String payHistoryCode
			,Model model) {
		//결제관리 코드 검사
		if(payHistoryCode == null || "".equals(payHistoryCode)) {
			System.out.println("결제코드 ERROR");
			return "redirect:/k1PaymentList/history";
		}
		//결제관리 상세
		resultMap = pService.getHistoryPaymentInfo(payHistoryCode);
		if(resultMap == null) {
			System.out.println("결제관리코드 ERROR");
			return "redirect:/k1PaymentList/history";
		}
		
		historyPaymentInfo = (HistoryPayment) resultMap.get("historyPaymentInfo");
		historyPaymentInfoList = (List<HistoryPayment>) resultMap.get("historyPaymentInfoList");
		
		model.addAttribute("SectionTitle", "결제관리");
		model.addAttribute("SectionLocation", "상세정보");
		model.addAttribute("historyPaymentInfo", historyPaymentInfo);
		model.addAttribute("historyPaymentInfoList", historyPaymentInfoList);
		return "payment/historyPayment_detail";
	}
		
	//결제내역 신규
		@GetMapping("/history/add")
		public String addHistoryPayment(Model model) {
			return "payment/historyPayment_register";
		}
	
	//결제내역 수정
	@GetMapping("/modify/{payHistoryCode}")
	public String modifyHistoryPayment(
			@PathVariable(value="payHistoryCode", required=false) String payHistoryCode
			,Model model) {
		model.addAttribute("title", "결제관리: 수정");
		model.addAttribute("payHistoryCode", payHistoryCode);
		return "payment/historyPayment_modify";
	}	
	
	//결제취소관리 상세
	@GetMapping("/cancel/{payCancelCode}")
	public String cancelPaymentInfo(
			@PathVariable(value="payCancelCode", required=false) String payCancelCode
			,Model model) {
		if(payCancelCode == null || "".equals(payCancelCode)) {
			System.out.println("결제취소코드 ERROR");
			return "redirect:/k1PaymentList/cancel";
		}
		
		cancelPaymentInfo = pService.getCancelPaymentInfo(payCancelCode);
		if(cancelPaymentInfo == null) {
			System.out.println("결제취소코드 ERROR");
			return "redirect:/k1SlipList/cancel";
		}
		
		model.addAttribute("title", "결제취소관리: 상세정보");
		model.addAttribute("cancelPaymentInfo", cancelPaymentInfo);
		return "payment/cancelPayment_detail";
	}
	
	//결제취소관리 추가
	@GetMapping("/cancel/add")
	public String addCancelPayment(Model model) {
		model.addAttribute("title", "결제취소관리: 등록");
		return "payment/cancelPayment_register";
	}
	
	//결제취소관리 수정
	@GetMapping("/cancel/modify/{payCancelCode}")
	public String modifyCancelPayment(
			@PathVariable(value="planPayment", required=false) String payCancelCode
			,Model model) {
		model.addAttribute("title", "결제취소관리: 수정");
		model.addAttribute("planPayment", payCancelCode);
		return "payment/cancelPayment_modify";
	}
	
	
	//결제예정 상세
	@SuppressWarnings("unchecked")
	@GetMapping("/plan/{payPlanCode}")
	public String PlanPaymentInfo(
			@PathVariable(value="payPlanCode", required=false) String payPlanCode
			,Model model) {
		//결제예정 코드 검사
		if(payPlanCode == null || "".equals(payPlanCode)) {
			System.out.println("결제예정코드 ERROR");
			return "redirect:/k1PaymentList/plan";
		}
		//결제예정 상세
		resultMap = pService.getPlanPaymentInfo(payPlanCode);
		if(resultMap == null) return "redirect:/k1PaymentList/plan";
		
		planPaymentInfo = (PlanPayment) resultMap.get("planPaymentInfo");
		planPaymentInfoList = (List<PlanPayment>) resultMap.get("planPaymentInfoList");
		
		
		model.addAttribute("SectionTitle", "결제예정");
		model.addAttribute("SectionLocation", "상세정보");
		model.addAttribute("planPaymentInfo", planPaymentInfo);
		model.addAttribute("planPaymentInfoList", planPaymentInfoList);
		return "payment/planPayment_detail";
	}
	
	//결제예정 등록
	@GetMapping("/plan/add")
	public String addPlanPayment(Model model) {
		model.addAttribute("title", "결제예정: 등록");
		return "payment/planPayment_register";
	}
	
	//결제예정 수정
	@GetMapping("/plan/modify/{payPlanCode}")
	public String modifyPlanPayment(
			@PathVariable(value="payPlanCode", required=false) String payPlanCode
			,Model model) {
		model.addAttribute("title", "결제예정: 수정");
		model.addAttribute("payPlanCode", payPlanCode);
		return "payment/planPayment_modify";
	}
	
}
