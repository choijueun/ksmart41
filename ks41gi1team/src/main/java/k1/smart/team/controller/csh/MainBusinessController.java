package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Business")
public class MainBusinessController {
	private MainBusinessService mainBusinessService;
	private String mainBusinessCode;
	
	public MainBusinessController(MainBusinessService mainBusinessService) {
		this.mainBusinessService = mainBusinessService;
	}
	
	//사업장정보 전체목록
	@GetMapping("/businessList")
	public String getMainBusinessList(Model model) {
		mainBusinessCode = "fac_EHN_Jeonju_001"; //임시저장
		List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList(mainBusinessCode);
		model.addAttribute("SectionTitle", "사업장 조회");
		model.addAttribute("mainBusinessList", mainBusinessList);
		
		return "mainBusiness/business_list";
	}
	
	//사업장 등록
	@GetMapping("/businessRegister")
	public String mainBusinessRegister(Model model) {
		
		return "mainBusiness/business_register";
	}
	
	

}
