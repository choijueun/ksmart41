package k1.smart.team.service.csh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.mapper.csh.UserMapper;

@Service
@Transactional
public class UserService {
	private UserMapper userRegMapper;
	private List<UserReg> userRegList;
	private UserReg userRegDetail; //요청내역 상세
	private List<User> userList; //회원전체 목록
	private User userDetail;//화원정보 상세
	
	
	@Autowired
	private LoginService loginService; //로그인 최근내역
	
	//생성자 메서드
	public UserService(UserMapper userRegMapper) {
		this.userRegMapper = userRegMapper;
	}
	
	/**
	 * 회원등록(getAddUser)
	 * 회원삭제(userDelete)
	 * 회원가입요청 삭제(userRegDelete)
	 * @return 
	 * 
	 * 
	 */
	//회원등록
	public String getAddUser(User user) {
		String addUser = userRegMapper.getAddUser(user);
		return addUser;
	}
	//아이디중복검사
	public int getIdCheck(String userId) {
		return userRegMapper.getIdCheck(userId);
	}
	
	//회원 전체 목록
	public List<User> getAllUserList() {
		userList = userRegMapper.getAllUserList(null);
		if(userList == null) {
			System.out.println("검색결과 없음");
			return null;
		}
		System.out.println("userList 서비스" + userList);
		return userList;
	}
	//회원정보 상세
	public User getUserDetail(String userId) {
		userDetail = userRegMapper.getUserDetail(userId);
		if(userDetail == null) {
			System.out.println("조회 결과 없음");
			return null;
		}
		userDetail.setUserId(userId);
		return userDetail;
	}
	//회원정보 수정
	public int modifyUser(User user) {
		return userRegMapper.modifyUser(user);
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
		System.out.println("userRegList 서비스" + userRegList);
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
	public int modifyUserReg(UserReg userReg) {
		
		return userRegMapper.modifyUserReg(userReg);
	}

	//관리자페이지에서 최근 회원목록 보여주기
	public List<User> getLimitUserList() {
		List<User> limitUser = userRegMapper.getLimitUserList();
		
		return limitUser;
	}

	

	

	

	
	
	
	

	

}
