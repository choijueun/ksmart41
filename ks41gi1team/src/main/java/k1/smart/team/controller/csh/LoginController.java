package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.csh.LoginService;

@Controller
@RequestMapping(value="/k1Login")
public class LoginController {
	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//로그인 내역
	@GetMapping("/loginList")
	public String getLoginList(Model model) {
		
		return "login/login_list";
	}
	

}
