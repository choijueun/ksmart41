package k1.smart.team.service.csh;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.mapper.csh.UserRegMapper;

@Service
@Transactional
public class UserRegService {
	private UserRegMapper userRegMapper;
	private List<UserReg> userRegList;
	
	//생성자 메서드
	public UserRegService(UserRegMapper userRegMapper) {
		this.userRegMapper = userRegMapper;
	}
	public List<UserReg> getAllUserRegList(String mainBusinessCode) {
		userRegList = userRegMapper.getAllUserRegList(mainBusinessCode);
		String userRegNum;
		for(int i=0; i<userRegList.size(); i++) {
			userRegNum = userRegList.get(i).getUserRegCode().replace("userRegCode_", "");
			userRegList.get(i).setUserRegCode(userRegNum);
		}
		System.out.println(userRegList);
		return userRegList;
	}

	

}
