package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.CancelPayment;
import k1.smart.team.dto.pjh.HistoryPayment;
import k1.smart.team.dto.pjh.PlanPayment;

@Mapper
public interface PaymentMapper {
	//결제내역 전체조회
	public List<HistoryPayment> getHistoryPaymentList(String mainBusinessCode);
	//결제내역 상세조회(거래한 물건 하나일때)
	public HistoryPayment getHistoryPaymentInfo(String payHistoryCode);
	//결제내역 상세조회(거래한 물건 여럿일때)
	public List<HistoryPayment> getHistoryPaymentInfoList(String payHistoryCode);
	
	//결제취소내역 전체조회
	public List<CancelPayment> getCancelPaymentList(String mainBusinessCode);
	//결제취소내역 상세조회
	public CancelPayment getCancelPaymentInfo(String payCancelCode);
	//결제취소내역 등록시 코드세팅
	public String addPayCancelCode();
	//결제취소내역 등록
	public int addPayCancel(CancelPayment cancelPayment);
	//결제취소내역 수정
	public int cancelModify(CancelPayment CancelPayment);
	
	
	//결제예정 전체조회
	public List<PlanPayment> getPlanPaymentList(String mainBusinessCode);
	//결제예정 상세조회(거래한 물건 하나일때)
	public PlanPayment getPlanPaymentInfo(String payPlanCode);
	//결제예정 상세조회(거래한 물건 여럿일때)
	public List<PlanPayment> getPlanPaymentInfoList(String payPlanCode);
	
	
}
