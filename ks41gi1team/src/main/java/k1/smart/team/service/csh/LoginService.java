package k1.smart.team.service.csh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.mapper.csh.LoginMapper;


@Service
@Transactional
public class LoginService {
	private final LoginMapper loginMapper;
	private List<Login> loginList; //로그인 내역 목록
	private Login loginDetail; //로그인 상세
	
	//생성자메서드
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	public List<Map<String, Object>> getLoginHistory3() {
		return loginMapper.getLoginHistoryList(null);
	}
	
	//로그인, 회원가입 서비스 만들어라

	//로그인 내역 전체 목록
	public List<Login> getAllLoginList() {
		loginList = loginMapper.getAllLoginList();
		System.out.println(loginList);
		return loginList;
	}

	//관리자페이지에서 최근내역만 보여주기
	//로그인 내역
	public List<Login> getLimitLoginList() {
		List<Login> limit = loginMapper.getLimitLoginList();
		return limit;
	}

	//로그인내역 상세
	public Login getLoginDetail(String loginCode) {
		//로그인내역 상세
		loginDetail = loginMapper.getLoginDetail(loginCode);
		if(loginDetail == null) {
			System.out.println("조회 결과 없음");
			return null;
		}
		loginDetail.setLoginCode(loginCode);
		return loginDetail;
	}
	

}
