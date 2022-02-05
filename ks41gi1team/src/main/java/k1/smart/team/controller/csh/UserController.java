package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.service.csh.LoginService;
import k1.smart.team.service.csh.UserService;

@Controller
@RequestMapping(value="/k1UserReg")
public class UserController {
	private UserService userService;
	private List<UserReg> userRegList; //요청내역 배열
	private UserReg userRegDetail; //요청내역 상세
	private List<User> userList; //회원전체 목록
	private User userDetail;//회원정보 상세
	
	@Autowired
	private LoginService loginService; //로그인 최근내역
	
	//생성자메서드(의존선 주입)
	public UserController( UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 회원 정보
	 */
	//회원 전체 목록
	@GetMapping("/userList")
	public String userList(Model model) {
		userList = userService.getAllUserList();
		
		model.addAttribute("SectionTitle", "회원 목록");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("userList", userList);
		
		return "user/user_list";
	}
	
	//회원정보 등록화면
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("SectionTitle", "회원정보");
		model.addAttribute("SectionLocation", "회원정보 등록");
		return "user/user_register";
	}
	//회원정보 등록 프로세스
	@PostMapping("/addUser")
	public String addUser(UserReg userReg) {
		System.out.println("UserController에서 회원가입 입력받은 값" + userReg);
		
		//insert처리
		String userId = userReg.getUserId();
		if(userId != null && !"".equals(userId)) {
			userReg.setUserRegCode("");
			userService.getAddUser(userReg);
		}
		return "redirect:/k1UserReg/addUser";
	}
	//회원아이디 중복검사
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(value = "userId", required = false) String userId ) {
		System.out.println("ajax 통신으로 요청받은 param userId: " + userId);
		boolean idCheckResult = false;
		int idCheck = userService.getIdCheck(userId);
		if(idCheck > 0) {
			idCheckResult = true;
		}
		return idCheckResult;
	}
	
	
	//회원정보 수정
	@GetMapping("/modifyUser/{userId}")
	public String modifyUser(
			@PathVariable(value = "userId", required = false) String userId
			,Model model) {
		
		User getUserDetail = userService.getUserDetail(userId);
		model.addAttribute("getUserDetail", getUserDetail);
		System.out.println(userId+"받아온 userId (controller)");
		if(userId != null && !"".equals(userId)) {
			User getUser = userService.getUserDetail(userId);
			model.addAttribute("getUser", getUser);
		}
		model.addAttribute("SectionTitle", "회원가입");
		model.addAttribute("SectionLocation", "회원가입 수정");
		model.addAttribute("userId", userId);
		return "user/user_modify";
	}
	//회원정보 수정
	@PostMapping("/modifyUser/{userId}")
	public String modifyUser(User user) {
		userService.modifyUser(user);
		return "redirect:/k1UserReg/userList";
	}
	//회원정보 삭제
	@GetMapping("/userDelete/{userId}")
	public String userDelete() {
		
		return "user/user_list";
	}
	
	
	
	//회원정보 상세
	@GetMapping("/userDetail/{userId}")
	public String getUserDetail(
			@PathVariable(value = "userId", required = false) String userId
			,Model model) {
		System.out.println("userId" + userId);
		
		//회원 검사
		if(userId == null || "".equals(userId)) {
			System.out.println("회원 상세 error");
			return "redirect:/userList";
		}
		
		//회원 상세
		userDetail = userService.getUserDetail(userId);
		if(userDetail == null) {
			System.out.println("회원 상세 error");
			return "redirect:/userList";
		}
		model.addAttribute("SectionTitle", "회원 정보");
		model.addAttribute("SectionLocation", "회원가입 상세");
		model.addAttribute("userDetail", userDetail);
		
		return "user/user_detail";
	}
	
	/**
	 * 관리자페이지
	 */
	//관리자 페이지
	@GetMapping("/managerPage")
	public String managerPage(Model model) {
		//로그인 최근내역
		//List<Login> loginList = loginService.getAllLoginList();
		
		List<Login> loginList2 = loginService.getLimitLoginList();
		userList = userService.getLimitUserList();
		
		model.addAttribute("SectionTitle", "관리자 페이지");
		model.addAttribute("SectionLocation", "회원관리");
		System.out.println(loginList2);
		System.out.println(userList);
		
		//로그인 최근내역
		model.addAttribute("loginList2", loginList2);
		//회원목록 최근순서
		model.addAttribute("userList", userList);
		
		
		return "user/manager_page";
	}
	//회원 마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("SectionTitle", "마이페이지");
		model.addAttribute("SectionLocation", "마이페이지");
		
		return "user/user_mypage";
	}
	//관리자페이지 calrendar 이동
	@GetMapping("/calrendar")
	public String calrendar() {
		
		return "user/calrendar";
	}
	
	
	
	/**
	 * 회원가입 요청
	 */
	//회원가입 요청 전체목록
	@GetMapping("/userRegList")
	public String getUserRegList(Model model) {
		userRegList = userService.getAllUserRegList();
		model.addAttribute("SectionTitle", "회원가입 요청 목록");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("userRegList", userRegList);
		return "user/userReg_register";
	}
	
	//회원가입 요청 상세정보
	@GetMapping("/userRegDetail/{userRegCode}")
	public String getUserRegDetail(
			 @PathVariable(value = "userRegCode", required = false) String userRegCode
			,Model model) {
		System.out.println(userRegCode);
		
		//회원가입 요청코드 검사
		if(userRegCode == null || "".equals(userRegCode)) {
			System.out.println("회원가입 요청 상세 error");
			return "redirect:/userRegList";
		}
		
		//회원가입요청 상세
		userRegDetail = userService.getAllUserRegDetail(userRegCode);
		if(userRegDetail == null) {
			System.out.println("회원가입 요청 상세 error");
			return "redirect:/userRegList";
		}
		model.addAttribute("SectionTitle", "회원가입 요청");
		model.addAttribute("SectionLocation", "상세");
		model.addAttribute("userRegDetail", userRegDetail);
		return "user/userReg_detail";
	}
	
	//회원가입 요청 수정
	@GetMapping("/modifyUserReg/{userRegCode}")
	public String modifyUserReg(
			@PathVariable(value = "userRegCode", required = false) String userId
			,Model model) {
		
		UserReg getAllUserRegDetail = userService.getAllUserRegDetail(userId);
		model.addAttribute("getAllUserRegDetail", getAllUserRegDetail);
		System.out.println(userId+"받아온 userId (controller)");
		if(userId != null && !"".equals(userId)) {
			UserReg getUserReg = userService.getAllUserRegDetail(userId);
			model.addAttribute("getUserReg", getUserReg);
		}
		model.addAttribute("SectionTitle", "회원가입 요청");
		model.addAttribute("SectionLocation", "수정");
		model.addAttribute("userId", userId);
		return "user/userReg_modify";
	}
	
	//회원가입 요청 수정
	@PostMapping("/modifyUserReg/{userRegCode}")
	public String modifyUserReg(UserReg userReg) {
		userService.modifyUserReg(userReg);
		return "redirect:/k1UserReg/userRegList";
	}
	//회원가입요청 삭제
	@GetMapping("/userRegDelete/{userRegCode}")
	public String userRegDelete() {
		return "user/userReg_register";
	}
			

}
