package k1.smart.team.service.csh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.mapper.csh.LoginMapper;


@Service
@Transactional
public class LoginService {
	private final LoginMapper loginMapper;
	
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	public List<Map<String, Object>> getLoginHistory3() {
		return loginMapper.getLoginHistoryList(null);
	}

}
