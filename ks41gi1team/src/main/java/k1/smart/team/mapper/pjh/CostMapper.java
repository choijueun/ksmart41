package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.Cost;

@Mapper
public interface CostMapper {
	//기타비용 전체조회
	public List<Cost> getAllCostList(String mainBusinessCode);
	//기타비용 상세
	public List<Cost> getCostInfo(String mainBusinessCode);
}
