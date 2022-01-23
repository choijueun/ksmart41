package k1.smart.team.service.pjh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.CancelPayment;
import k1.smart.team.dto.pjh.HistoryPayment;
import k1.smart.team.dto.pjh.PlanPayment;
import k1.smart.team.mapper.pjh.PaymentMapper;

@Service
public class PaymentService {
	private PaymentMapper paymentMapper;
	private List<HistoryPayment> historyPaymentList;
	private List<CancelPayment> cancelPaymentList;
	private List<PlanPayment> planPaymentList;
	private PlanPayment planPaymentInfo;
	private List<PlanPayment> planPaymentInfoList;
	private CancelPayment cancelPaymentInfo;
	private HistoryPayment historyPaymentInfo;
	private List<HistoryPayment> historyPaymentInfoList;
	private Map<String,Object> resultMap = new HashMap<String,Object>();
	
	
	public PaymentService(PaymentMapper paymentMapper) {
		this.paymentMapper = paymentMapper;
	}
	
	public List<HistoryPayment> getHistoryPaymentList(String mainBusinessCode) {
		System.out.println("Service: "+mainBusinessCode);
		historyPaymentList = paymentMapper.getHistoryPaymentList(mainBusinessCode);
		return historyPaymentList;
	}
	
	public List<PlanPayment> getPlanPaymentList(String mainBusinessCode) {
		 planPaymentList = paymentMapper.getPlanPaymentList(mainBusinessCode);
		 
		 return planPaymentList;
		 
	}
	
	public List<CancelPayment> getCancelPaymentList(String mainBusinessCode) {
		cancelPaymentList = paymentMapper.getCancelPaymentList(mainBusinessCode);
		
		return cancelPaymentList;
	}
	
	public Map<String,Object> getPlanPaymentInfo(String payPlanCode) {
		planPaymentInfo = paymentMapper.getPlanPaymentInfo(payPlanCode); //결제예정 품목 하나 상세
		if(planPaymentInfo == null) {
			System.out.println("결제예정정보 조회결과 없음");
			return null;
		}
		planPaymentInfoList = paymentMapper.getPlanPaymentInfoList(payPlanCode);//결제예정 품목 여러개 상세
		
		resultMap.clear();
		resultMap.put("planPaymentInfo", planPaymentInfo);
		resultMap.put("planPaymentInfoList", planPaymentInfoList);
		
		return resultMap;
	}
	
	public CancelPayment getCancelPaymentInfo(String payCancelCode) {
		cancelPaymentInfo = paymentMapper.getCancelPaymentInfo(payCancelCode);
		if(cancelPaymentInfo == null) {
			System.out.println("결제취소정보 조회결과 없음");
			return null;
		}
		
		cancelPaymentInfo.setPayCancelCode(payCancelCode);
		return cancelPaymentInfo;
	}
	
	public Map<String,Object> getHistoryPaymentInfo(String payHistoryCode) {
		historyPaymentInfo = paymentMapper.getHistoryPaymentInfo(payHistoryCode); //결제예정 품목 하나 상세
		if(historyPaymentInfo == null) {
			System.out.println("결제정보 조회결과 없음");
			return null;
		}
		historyPaymentInfoList = paymentMapper.getHistoryPaymentInfoList(payHistoryCode);//결제정보 품목 상세 여러개
		
		resultMap.clear();
		resultMap.put("historyPaymentInfo", historyPaymentInfo);
		resultMap.put("historyPaymentInfoList", historyPaymentInfoList);
		return resultMap;
	}
	
	//취소내역 등록시 코드세팅
	public String addPayCancelCode() {
		return paymentMapper.addPayCancelCode();
	}
	
	//취소내역 등록
	public void addPayCancel(CancelPayment cancelPayment) {
		paymentMapper.addPayCancel(cancelPayment);
	}
	
}







