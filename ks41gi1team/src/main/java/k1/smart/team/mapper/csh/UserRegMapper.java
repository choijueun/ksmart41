package k1.smart.team.mapper.csh;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.csh.UserReg;

@Mapper
public interface UserRegMapper {
	
	//회원 전체 목록
	public List<User> getAllUserList();
	
	//회원가입 요청 전체조회
	public List<UserReg> getAllUserRegList();
	
	// 로그인 이력 테이블 튜플의 총 갯수
	public int getLoginHistoryCount();
		
	// 로그인 이력 조회
	public List<Map<String, Object>> getLoginHistoryList(Map<String, Object> paramMap);
	
	//로그인 이력 조회
	public List<Login> getAllLoginList();

	//회원가입요청 상세
	public UserReg getUserRegDetail(String userRegCode);

	//회원가입 요청 수정
	public int modifyUserReg(UserReg userReg);

	

}
