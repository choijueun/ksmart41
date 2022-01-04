package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.csh.BusinessService;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Business")
public class BusinessController {
	private BusinessService businessService;
	
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	//사업장정보 전체목록
	@GetMapping("/businessList")
	public String getBusinessList(Model model) {
		
		return "mainBusiness/business_list";
	}
	
	//사업장 등록
	@GetMapping("/businessRegister")
	public String businessRegister(Model model) {
		
		return "mainBusiness/business_register";
	}
	
	

}
