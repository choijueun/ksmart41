package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.UserReg;
import k1.smart.team.service.csh.UserRegService;

@Controller
@RequestMapping(value="/k1UserReg")
public class UserRegController {
	private UserRegService userRegService;
	private List<UserReg> userRegList; //요청내역 배열
	private UserReg userRegDetail; //요청내역 상세
	
	public UserRegController( UserRegService userRegService) {
		this.userRegService = userRegService;
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
	
	
	

}
