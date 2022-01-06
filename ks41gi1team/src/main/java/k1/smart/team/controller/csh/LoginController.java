package k1.smart.team.controller.csh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.service.Mservice;
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
	public String loginHistory3 (Model model) {
		model.addAttribute("SectionTitle", 			"로그인 이력조회");
		
		return "login/loginHistory3";
	}
	
	@PostMapping("/loginList")
	@ResponseBody
	public List<Map<String, Object>> loginHistory3 () {
		
		List<Map<String, Object>> loginHistoryList = loginService.getLoginHistory3();
		
		return loginHistoryList;
	}
	
	
}
