package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Business")
public class MainBusinessController {
	private MainBusinessService mainBusinessService;
	
	public MainBusinessController(MainBusinessService mainBusinessService) {
		this.mainBusinessService = mainBusinessService;
	}
	
	//사업장정보 전체목록
	@GetMapping("/businessList")
	public String getMainBusinessList(Model model) {
		List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
		model.addAttribute("SectionTitle", "사업장 조회");
		model.addAttribute("mainBusinessList", mainBusinessList);
		
		return "mainBusiness/business_list";
	}
	
	//사업장 등록
	@GetMapping("/businessRegister")
	public String mainBusinessRegister(Model model) {
		model.addAttribute("SectionTitle", "사업장 등록");
		
		return "mainBusiness/business_register";
	}
	
	//사업자번호 중복검사
	@PostMapping("/businessNumCheck")
	@ResponseBody
	public boolean businessNumCheck(@RequestParam(value = "businessNum", required = false)String businessNum) {
		System.out.println("ajax 통신으로 요청받은 param businessNum: " + businessNum);
		
		boolean checkResult = false;
		
		int businessNumCheck = mainBusinessService.getBusinessByNum(businessNum);
		
		if(businessNumCheck > 0) checkResult = true;
		
		return checkResult;
	}
	

}
