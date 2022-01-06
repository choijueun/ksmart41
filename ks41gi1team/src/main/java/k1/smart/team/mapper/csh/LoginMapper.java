package k1.smart.team.mapper.csh;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	// 로그인 이력 테이블 튜플의 총 갯수
	public int getLoginHistoryCount();
		
	// 로그인 이력 조회
	public List<Map<String, Object>> getLoginHistoryList(Map<String, Object> paramMap);

}
