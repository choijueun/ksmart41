package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.Cost;

@Mapper
public interface CostMapper {
	//기타비용 전체조회
	public List<Cost> getAllCostList(String mainBusinessCode);
	//기타비용 상세
	public Cost getCostInfoByCode(String etcPurchaseCode);
	
	//기타비용 등록
	public int addCost(Cost cost);
	
	//기타비용 코드 가져오기 
	public String getAddCostCode();
	
	//기타비용 수정
	public int costModify(Cost cost);
	
}
