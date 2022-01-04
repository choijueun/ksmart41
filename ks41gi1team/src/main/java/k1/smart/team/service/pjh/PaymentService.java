package k1.smart.team.service.pjh;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.CancelPayment;
import k1.smart.team.dto.pjh.HistoryPayment;
import k1.smart.team.dto.pjh.PlanPayment;
import k1.smart.team.mapper.pjh.PaymentMapper;

@Service
public class PaymentService {
	private PaymentMapper paymentMapper;
	private List<HistoryPayment> historyPayment;
	private List<CancelPayment> cancelPayment;
	private List<PlanPayment> planPayment;
	
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	public List<HistoryPayment> getHistoryPaymentList(String mainBusinessCode) {
		historyPayment = paymentMapper.getHistoryPaymentList(mainBusinessCode);
		String paymentNum;
		for(int i=0; i<historyPayment.size(); i++) {
			paymentNum = historyPayment.get(i).getPayHistoryCode().replace("", "");
			historyPayment.get(i).setPayHistoryCode(paymentNum);
		}
		return historyPayment;
	}
	public List<PlanPayment> getPlanPaymentList(String mainBusinessCode) {
		planPayment = paymentMapper.getPlanPaymentList(mainBusinessCode);
		System.out.println("PaymentService !!!!!!!!!!!!! "+planPayment);
		String paymentNum;
		for(int i=0; i<planPayment.size(); i++) {
			paymentNum = planPayment.get(i).getPayPlanCode().replace("payPlanCode_", "");
			planPayment.get(i).setPayPlanCode(paymentNum);
		}
		System.out.println("PaymentService !!!!!!!!!!!!! "+planPayment);
		return planPayment;
	}
	public List<CancelPayment> getCancelPaymentList(String mainBusinessCode) {
		cancelPayment = paymentMapper.getCancelPaymentList(mainBusinessCode);
		String paymentNum;
		for(int i=0; i<cancelPayment.size(); i++) {
			paymentNum = cancelPayment.get(i).getPayCancelCode().replace("", "");
			cancelPayment.get(i).setPayCancelCode(paymentNum);
		}
		return cancelPayment;

	}
}