package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.csh.UserRegService;

@Controller
@RequestMapping(value="/k1UserReg")
public class UserRegController {
	private UserRegService userRegService;
	
	public UserRegController( UserRegService userRegService) {
		this.userRegService = userRegService;
	}
	
	//회원가입 요청 전체목록
	@GetMapping("")
	public String getUserRegList(Model model) {
		
		return "user/user_register";
	}
	
	
	

}
