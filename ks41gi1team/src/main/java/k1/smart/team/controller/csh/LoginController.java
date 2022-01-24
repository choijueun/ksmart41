package k1.smart.team.controller.csh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.csh.Login;
import k1.smart.team.service.Mservice;
import k1.smart.team.service.csh.LoginService;

@Controller
@RequestMapping(value="/k1Login")
public class LoginController {
	private LoginService loginService;
	private Login loginDetail; //로그인 상세
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//회원가입
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String login() {
		return "login/login";
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
	
	
}
