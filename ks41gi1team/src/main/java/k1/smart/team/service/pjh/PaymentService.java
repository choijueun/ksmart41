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
	
	public List<HistoryPayment> getAllHistoryPaymentList(String mainBusinessCode) {
		historyPayment = paymentMapper.getAllHistoryPaymentList(mainBusinessCode);
		String paymentNum;
		for(int i=0; i<historyPayment.size(); i++) {
			paymentNum = historyPayment.get(i).getPayHistoryCode().replace("", "");
			historyPayment.get(i).setPayHistoryCode(paymentNum);
		}
		return historyPayment;
	}
	public List<PlanPayment> getAllPlanPaymentList(String mainBusinessCode) {
		planPayment = paymentMapper.getAllPlanPaymentList(mainBusinessCode);
		String paymentNum;
		for(int i=0; i<planPayment.size(); i++) {
			paymentNum = planPayment.get(i).getPayPlanCode().replace("", "");
			planPayment.get(i).setPayPlanCode(paymentNum);
		}
		return planPayment;
	}
	public List<CancelPayment> getAllCancelPaymentList(String mainBusinessCode) {
		cancelPayment = paymentMapper.getAllCancelPayment(mainBusinessCode);
		String paymentNum;
		for(int i=0; i<cancelPayment.size(); i++) {
			paymentNum = cancelPayment.get(i).getPayCancelCode().replace("", "");
			cancelPayment.get(i).setPayCancelCode(paymentNum);
		}
		return cancelPayment;

	}
}