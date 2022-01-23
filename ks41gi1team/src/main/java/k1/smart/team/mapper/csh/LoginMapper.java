package k1.smart.team.mapper.csh;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Login;

@Mapper
public interface LoginMapper {
	
	//관리자페이지에서 최근 로그인내역만 보여주기
	public List<Login> getLimitLoginList();

	// 로그인 이력 테이블 튜플의 총 갯수
	public int getLoginHistoryCount();
		
	// 로그인 이력 조회
	public List<Map<String, Object>> getLoginHistoryList(Map<String, Object> paramMap);

	// 로그인 내역 전체 목록
	public List<Login> getAllLoginList();

	
}
