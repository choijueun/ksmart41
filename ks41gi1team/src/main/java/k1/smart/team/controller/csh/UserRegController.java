package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.service.csh.LoginService;
import k1.smart.team.service.csh.UserRegService;

@Controller
@RequestMapping(value="/k1UserReg")
public class UserRegController {
	private UserRegService userRegService;
	private List<UserReg> userRegList; //요청내역 배열
	private UserReg userRegDetail; //요청내역 상세
	private List<User> userList; //회원전체 목록
	
	@Autowired
	private LoginService loginService; //로그인 최근내역
	
	
	public UserRegController( UserRegService userRegService) {
		this.userRegService = userRegService;
	}
	//회원 전체 목록
	@GetMapping("/userList")
	public String userList(Model model) {
		userList = userRegService.getAllUserList();
		
		model.addAttribute("SectionTitle", "회원 전체 목록");
		
		return "user/user_list";
	}
	
	
	//관리자 페이지
	@GetMapping("/managerPage")
	public String managerPage(Model model) {
		//로그인 최근내역
		//List<Login> loginList = loginService.getAllLoginList();
		
		List<Login> loginList2 = loginService.getLimitLoginList();
		
		model.addAttribute("SectionTitle", "관리자 페이지");
		System.out.println(loginList2);
		
		//로그인 최근내역
		model.addAttribute("loginList2", loginList2);
		
		
		return "user/manager_page";
	}
	
	//회원 마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("SectionTitle", "마이페이지");
		
		return "user/user_mypage";
	}
	
	//회원가입 요청 전체목록
	@GetMapping("/userRegList")
	public String getUserRegList(Model model) {
		userRegList = userRegService.getAllUserRegList();
		model.addAttribute("SectionTitle", "회원가입 요청 목록");
		model.addAttribute("userRegList", userRegList);
		return "user/user_register";
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
		userRegDetail = userRegService.getAllUserRegDetail(userRegCode);
		if(userRegDetail == null) {
			System.out.println("회원가입 요청 상세 error");
			return "redirect:/userRegList";
		}
		model.addAttribute("SectionTitle", "회원가입 요청 상세");
		model.addAttribute("userRegDetail", userRegDetail);
		return "user/user_detail";
	}
	
	//회원가입 요청 수정
	@GetMapping("/modify/{userRegCode}")
	public String modifyUserReg(
			@PathVariable(value = "userRegCode", required = false) String userId
			,Model model) {
		
		UserReg getAllUserRegDetail = userRegService.getAllUserRegDetail(userId);
		model.addAttribute("getAllUserRegDetail", getAllUserRegDetail);
		System.out.println(userId+"받아온 userId (controller)");
		if(userId != null && !"".equals(userId)) {
			UserReg getUserReg = userRegService.getAllUserRegDetail(userId);
			model.addAttribute("getUserReg", getUserReg);
		}
		model.addAttribute("SectionTitle", "회원가입 요청: 수정");
		model.addAttribute("userId", userId);
		return "user/user_modify";
	}
	
	//회원가입 요청 수정
	@PostMapping("/modify/{userRegCode}")
	public String modifyUserReg(UserReg userReg) {
		userRegService.modifyUserReg(userReg);
		return "redirect:/k1UserReg/userRegList";
	}
			
	
	
	
	
	
	
	
	
	

}
