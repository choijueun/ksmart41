package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StoringMapper {
	/**
	 * 물류내역 전체조회
	 * @param mainBusinessCode
	 * @return 물류내역 여럿(List<Storing>)
	 */
	public List<Storing> getAllStoringList(String mainBusinessCode, String stockReasonCode);

	public Storing getAdjInfo(String stockAdjCode);
	
	public List<Storing> getAdjDetailInfo(String stockAdjCode);
}
