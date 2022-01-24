package k1.smart.team.mapper.psb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.PurchaseTransaction;

@Mapper
public interface PurchaseTransactionMapper {

	//비용거래명세서 전체조회
	List<Map<String, Object>> getPurchaseTransactionHistoryList(Map<String, Object> paramMap);

	//비용거래명세서 상세
	public PurchaseTransaction getPurchaseTransactionInfo(String purchaseTsCode);
	
	//비용거래명세서 등록
    public int addPurchaseTransaction(PurchaseTransaction purchaseTransaction);

    public List<PurchaseTransaction> getPurchaseTransactionList();

    //코드 추가할때마다 자동 생성되는
	public String getPurchaseTransactionCode();	
	
}
