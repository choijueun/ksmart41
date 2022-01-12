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
	private UserReg userRegDetail; //요청내역 상세
	
	//생성자 메서드
	public UserRegService(UserRegMapper userRegMapper) {
		this.userRegMapper = userRegMapper;
	}
	
	//회원가입 요청 목록
	public List<UserReg> getAllUserRegList() {
		userRegList = userRegMapper.getAllUserRegList();
		if(userRegList == null) {
			System.out.println("검색결과 없음");
			return null;
		}
		String userRegNum;
		for(int i=0; i<userRegList.size(); i++) {
			userRegNum = userRegList.get(i).getUserRegCode().replace("userRegCode_", "");
			userRegList.get(i).setUserRegCode(userRegNum);
		}
		System.out.println(userRegList);
		return userRegList;
	}
	
	//회원가입 요청 상세
	public UserReg getAllUserRegDetail(String userRegCode) {
		//회원가입 요청 상세
		userRegDetail = userRegMapper.getUserRegDetail(userRegCode);
		if(userRegDetail == null) {
			System.out.println("조회 결과 없음");
			return null;
		}
		userRegDetail.setUserRegCode(userRegCode);
		return userRegDetail;
	}
	
	//회원가입 요청 수정
	

	

}
