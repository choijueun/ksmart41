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
	
	private LoginService memberService;
	
	public LoginController(LoginService memberService) {
		this.memberService = memberService;
	}
	
	//로그인 내역
	@GetMapping("/loginList")
	public String getLoginList(Model model) {
		model.addAttribute("title", 			"로그인 이력조회");
		return "login/login_list";
	}
	

}
