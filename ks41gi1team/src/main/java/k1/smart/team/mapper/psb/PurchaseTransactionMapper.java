package k1.smart.team.mapper.psb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseTransactionMapper {

	//비용거래명세서 전체조회
	List<Map<String, Object>> getPurchaseTransactionHistoryList(Map<String, Object> paramMap);

	
}
