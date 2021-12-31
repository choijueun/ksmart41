package k1.smart.team.controller.pjh;

import java.util.List;

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
	
	public PaymentController(PaymentService pService) {
		this.pService = pService;
	}
	
	//결제관리 전체조회
	@GetMapping("")
	public String HistoryPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<HistoryPayment> historyPayment = pService.getHistoryPaymentList(mainBusinessCode);
		
		model.addAttribute("title","결제관리");
		model.addAttribute("historyPayment", historyPayment);
		
		return "payment/historyPayment_list";
	}
	
	//결제관리 상세
	@GetMapping("/{payHistoryCode}")
	public String HistoryPaymentInfo(
			@PathVariable(value="payHistoryCode", required=false) String payHistoryCode
			,Model model) {
		model.addAttribute("title", "결제관리: 상세정보");
		model.addAttribute("payHistoryCode", payHistoryCode);
		return "payment/historyPayment_detail";
	}
	
	//결제내역 신규
		@GetMapping("/addPlan")
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
	
	//결제취소내역 전체조회
	@GetMapping("/cancel")
	public String CancelPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<CancelPayment> cancelPayment = pService.getCancelPaymentList(mainBusinessCode);
		
		model.addAttribute("title","결제취소 관리");
		model.addAttribute("cancelPayment", cancelPayment);
		
		return "payment/cancelPayment_list";
	}
	
	//결제취소관리 상세
	@GetMapping("/cancel/{payCancelCode}")
	public String CancelPaymentInfo(
			@PathVariable(value="payCancelCode", required=false) String payCancelCode
			,Model model) {
		model.addAttribute("title", "결제취소관리: 상세정보");
		model.addAttribute("payCancelCode", payCancelCode);
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
			@PathVariable(value="payCancelCode", required=false) String payCancelCode
			,Model model) {
		model.addAttribute("title", "결제취소관리: 수정");
		model.addAttribute("payCancelCode", payCancelCode);
		return "payment/cancelPayment_modify";
	}
	
	//결제예정 조회
	@GetMapping("/plan")
	public String PlanPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<PlanPayment> planPayment = pService.getPlanPaymentList(mainBusinessCode);
		System.out.println("PaymentController !!!!!!!!!!!!! "+planPayment);
		model.addAttribute("title","결제예정");
		model.addAttribute("planPayment", planPayment);
		
		return "payment/planPayment_list";
	}
	
	//결제예정 상세
	@GetMapping("/plan/{payPlanCode}")
	public String PlanPaymentInfo(
			@PathVariable(value="payPlanCode", required=false) String payPlanCode
			,Model model) {
		model.addAttribute("title", "결제예정: 상세정보");
		model.addAttribute("payPlanCode", payPlanCode);
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
		model.addAttribute("title", "운송요청: 수정");
		model.addAttribute("payPlanCode", payPlanCode);
		return "payment/planPayment_modify";
	}
	
}
