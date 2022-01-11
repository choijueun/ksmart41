package k1.smart.team.mapper.csh;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.UserReg;

@Mapper
public interface UserRegMapper {
	
	//회원가입 요청 전체조회
	List<UserReg> getAllUserRegList();
	
	// 로그인 이력 테이블 튜플의 총 갯수
	public int getLoginHistoryCount();
		
	// 로그인 이력 조회
	public List<Map<String, Object>> getLoginHistoryList(Map<String, Object> paramMap);

	//회원가입요청 상세
	public UserReg getUserRegDetail(String userRegCode);

}
