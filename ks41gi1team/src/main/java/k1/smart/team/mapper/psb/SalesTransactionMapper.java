package k1.smart.team.mapper.psb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.SalesTransaction;

@Mapper
public interface SalesTransactionMapper {

	//매출거래명세서 전체 조회	
	public List<Map<String, Object>> getSalesTransactionHistoryList(Map<String, Object> paramMap);
}
