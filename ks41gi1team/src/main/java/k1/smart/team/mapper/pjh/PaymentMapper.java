package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.CancelPayment;
import k1.smart.team.dto.pjh.HistoryPayment;
import k1.smart.team.dto.pjh.PlanPayment;

@Mapper
public interface PaymentMapper {
	//결제내역 전체조회
	public List<HistoryPayment> getAllHistoryPaymentList(String mainBusinessCode);
	//결제내역 상세조회
	public List<HistoryPayment> getHistoryPaymentInfo(String mainBusinessCode);
	
	//결제취소내역 전체조회
	public List<CancelPayment> getAllCancelPayment(String mainBusinessCode);
	//결제취소내역 상세조회
	public List<CancelPayment> getCancelPaymentInfo(String mainBusinessCode);
	
	//결제예정 전체조회
	public List<PlanPayment> getAllPlanPaymentList(String mainBusinessCode);
	//결제예정 상세조회
	public List<PlanPayment> getPlanPaymentInfo(String mainBusinessCode);
}
