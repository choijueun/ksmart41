package k1.smart.team.controller.csh;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.dto.csh.User;
import k1.smart.team.service.csh.LoginService;

@Controller
@RequestMapping(value="/k1Login")
public class LoginController{
	private LoginService loginService;
	private Login loginDetail; //로그인 상세
	
	//생성자메서드(의존성 주입)
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//회원가입
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}
	
	/**
	 * 관리자 로그인
	 * @return
	 */
	//관리자로그인
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	//관리자 로그인
	@PostMapping("/login")
	public String login(@RequestParam(value = "userId",required = false)String userId
						,@RequestParam(value = "userPw",required = false)String userPw
						,HttpSession session ) {
		System.out.println("로그인 아이디" + userId);
		System.out.println("로그인 비밀번호" + userPw);
		if(userId != null && !"".equals(userId) && userPw != null && !"".equals(userPw)) {
			User userInfo = loginService.getUserIdCheck(userId);
			if(userInfo != null 
					&& userInfo.getUserPw() != null 
					&& userPw.equals(userInfo.getUserPw())) {
				//로그인 비밀번호 일치 시 세션을 정보에 담음
				session.setAttribute("UID", userId);
				session.setAttribute("UNAME", userInfo.getUserName());
				session.setAttribute("ULEVEL", userInfo.getUserLevel());
				session.setAttribute("ULEVELNAME", userInfo.getUserLevelName());
				session.setAttribute("MAINBUSINESSCODE", "fac_ksmartSeoul_Seoul_001");
				session.setAttribute("UBUSINESSNAME", userInfo.getBusinessName());
				return "redirect:/main";
			}
		}
		//로그인 불일치 시
		return "redirect:/login";
	}
	
	/**
	 * 일반직원 로그인
	 */
	//일반직원 로그인
	@GetMapping("/login2")
	public String login2() {
		return "login/login2";
	}
	//일반직원 로그인
	@PostMapping("/login2")
	public String login2(@RequestParam(value = "userId",required = false)String userId
						,@RequestParam(value = "userPw",required = false)String userPw
						,HttpSession session ) {
		System.out.println("로그인 아이디" + userId);
		System.out.println("로그인 비밀번호" + userPw);
		if(userId != null && !"".equals(userId) && userPw != null && !"".equals(userPw)) {
			User userInfo = loginService.getUserIdCheck(userId);
			if(userInfo != null 
					&& userInfo.getUserPw() != null 
					&& userPw.equals(userInfo.getUserPw())) {
				//로그인 비밀번호 일치 시 세션을 정보에 담음
				session.setAttribute("UID", userId);
				session.setAttribute("UNAME", userInfo.getUserName());
				session.setAttribute("ULEVEL", userInfo.getUserLevel());
				session.setAttribute("ULEVELNAME", userInfo.getUserLevelName());
				session.setAttribute("MAINBUSINESSCODE", "fac_ksmartSeoul_Seoul_001");
				session.setAttribute("UBUSINESSNAME", userInfo.getBusinessName());
				return "redirect:/main";
			}
		}
		//로그인 불일치 시
		return "redirect:/login2";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//로그인 내역
	@GetMapping("/loginList")
	public String loginList (Model model) {
		List<Login> loginList = loginService.getAllLoginList();
		model.addAttribute("SectionTitle", "로그인 이력조회");
		model.addAttribute("loginList", loginList);
		
		return "login/loginList";
	}
	
	//로그인 내역 상세
	@GetMapping("/loginDetail/{loginCode}")
	public String loginDetail(@PathVariable(value = "loginCode", required = false) String loginCode
			,Model model) {
		System.out.println(loginCode);
		
		//로그인내역코드 검사
		if(loginCode == null || "".equals(loginCode)) {
			System.out.println("거래처코드 error");
			return "redirect:/loginList";
		}
		//로그인 내역 상세
		loginDetail = loginService.getLoginDetail(loginCode);
		if(loginDetail == null) {
			System.out.println("로그인 내역 상세 error");
			return "redirect:/loginList";
		}
		model.addAttribute("SectionTitle", "로그인내역 상세");
		model.addAttribute("loginDetail", loginDetail);
		
		return "login/login_detail";
	}
	//로그인내역 삭제
	@GetMapping("/loginDelete")
	public String loginDelete() {
		
		return "login/loginList";
	}
	
}




