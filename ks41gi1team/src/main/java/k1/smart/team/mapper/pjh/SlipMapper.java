package k1.smart.team.mapper.pjh;

import java.util.List;
import java.util.Map;

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
	
	//전표 등록
	public int addSlip (Slip slip);
	//모달 판매리스트 
	public List<Map<String, Object>> saleTransactionList(Map<String,Object> paramMap);
}
