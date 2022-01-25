package k1.smart.team.mapper.pjh;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.Slip;

@Mapper
public interface SlipMapper {
	//비용전표 전체조회
	public List<Slip> getAll_P_SlipList(String mainBusinessCode);
	
	//매출전표 전체조회
	public List<Slip> getAll_S_SlipList(String mainBusinessCode);
	
	//매출전표정보 상세조회
	public Slip getPurchaseSlipInfo(String purchaseSlipCode);
	
	//비용전표정보 상세조회
	public Slip getSalesSlipInfo(String salesSlipCode);
	
	//비용명세서 조회
	public Slip getPurchaseTransactionCode(String mainBusinessCode);
	//매출명세서 조회
	public Slip getSalesTransactionCode(String mainBusinessCode);
	
	//매출 전표 날짜 코드화
	public String salesSlipNum (String slipDate);
	//매출전표 등록
	public void registerSalesSlip (Slip addSlip);
	
	//비용 전표 날짜 코드화
	public String purchaseSlipNum (String slipDate);
	//비용전표 등록
	public void registerPurchaseSlip (Slip addSlip);
	
	//모달 판매명세서리스트 
	public List<Slip> salesTransactionList();
	//모달 비용명세서리스트
	public List<Slip> purchaseTransactionList();
	
	//매출전표 수정시 값 가져오기 
	public Slip getSalesSlipData(String salesSlipCode);
	//매출전표 수정
	public int salesSlipModify(Slip slip);
	
	//비용전표 수정시 값 가져오기 
	public Slip getPurchaseSlipData(String purchaseSlipCode);
	//비용전표 수정
	public int purchaseSlipModify(Slip slip);
	
	//최주은-특정품목(거래처, 계약코드)의 비용 거래명세서 조회
	public List<Slip> getPSlipByItem(String itemCode, String mainBusinessCode);
}
