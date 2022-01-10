package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.service.csh.UserRegService;

@Controller
@RequestMapping(value="/k1UserReg")
public class UserRegController {
	private UserRegService userRegService;
	private String mainBusinessCode;
	
	public UserRegController( UserRegService userRegService) {
		this.userRegService = userRegService;
	}
	
	//회원가입 요청 전체목록
	@GetMapping("/userRegList")
	public String getUserRegList(Model model) {
		mainBusinessCode = "fac_EHN_Jeonju_001"; //임시저장
		List<UserReg> userRegList = userRegService.getAllUserRegList();
		model.addAttribute("SectionTitle", "회원가입 요청 목록");
		model.addAttribute("userRegList", userRegList);
		
		return "user/user_register";
	}
	
	
	

}
