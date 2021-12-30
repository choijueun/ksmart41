package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("")
	public String HistoryPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		//List<HistoryPayment> historyPayment = pService.getAllHistoryPaymentList(mainBusinessCode);
		
		model.addAttribute("title","결제관리");
		//model.addAttribute("historyPayment", historyPayment);
		
		return "payment/historyPayment_list";
	}
	@GetMapping("/cancel")
	public String CancelPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<CancelPayment> cancelPayment = pService.getAllCancelPaymentList(mainBusinessCode);
		
		model.addAttribute("title","결제취소 관리");
		model.addAttribute("cancelPayment", cancelPayment);
		
		return "payment/cancelPayment_list";
	}
	@GetMapping("/plan")
	public String PlanPayment(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<PlanPayment> planPayment = pService.getAllPlanPaymentList(mainBusinessCode);
		
		model.addAttribute("title","결제관리");
		model.addAttribute("planPayment", planPayment);
		
		return "payment/planPayment_list";
	}
}
