package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.service.csh.MainBusinessService;

@Controller
@RequestMapping(value="/k1Business")
public class MainBusinessController {
	private MainBusinessService mainBusinessService;
	private MainBusiness mainBusinessDetail;
	
	//생성자메서드(의존선 주입)
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
	//사업장등록
	@PostMapping("/businessRegister")
	public String addMainBusiness(MainBusiness mainBusiness) {
		System.out.println("MainBusinessController 등록 입력받은 값 :" + mainBusiness);
		String mainBusinessCode = mainBusiness.getMainBusinessCode();
		if(mainBusinessCode != null && !"".equals(mainBusinessCode)) {
			System.out.println(mainBusinessCode);
			mainBusinessService.addMainBusiness(mainBusiness);
		}
		return "redirect:/mainBusiness/business_register";
	}
	
	//사업장대표코드 중복검사
	@PostMapping("/mainBusinessCodeCheckBtn")
	@ResponseBody
	public boolean mainBusinessCodeCheckBtn(@RequestParam(value = "mainBusinessCode", required = false)String mainBusinessCode) {
		System.out.println("ajax 통신으로 요청받은 param mainBusinessCode: " + mainBusinessCode);
		
		boolean checkResult = false;
		int businessNumCheck = mainBusinessService.getBusinessByCode(mainBusinessCode);
		if(businessNumCheck > 0) checkResult = true;
		
		return checkResult;
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
	
	//사업장 상세정보
	@GetMapping("/mainBusinessDetail/{mainBusinessCode}")
	public String getMainBusinessDetail(
			@PathVariable(value = "mainBusinessCode", required = false) String mainBusinessCode
			,Model model) {
		System.out.println(mainBusinessCode);
		//사업장대표코드 검사
		if(mainBusinessCode == null || "".equals(mainBusinessCode)) {
			System.out.println("사업장 대표코드 error");
			return "redirect:/businessList";
		}
		//사업장 상세
		mainBusinessDetail = mainBusinessService.getMainBusinessDetail(mainBusinessCode);
		if(mainBusinessDetail == null) {
			System.out.println("사업장 상세 error");
		}
		model.addAttribute("SectionTitle", "사업장 상세");
		model.addAttribute("mainBusinessDetail", mainBusinessDetail);
		return "mainBusiness/business_detail";
	}
	
	//사업장 정보 수정
	@GetMapping("/modify/{mainBusinessCode}")
	public String modifyMainBusiness(
			@PathVariable(value = "mainBusinessCode", required = false) String mainBusinessCode
			,Model model) {
		
		MainBusiness getAllMainBusinessDetail = mainBusinessService.getMainBusinessDetail(mainBusinessCode);
		model.addAttribute("getAllMainBusinessDetail", getAllMainBusinessDetail);
		System.out.println(mainBusinessCode + "받아온 mainBusinessCode (controller)");
		
		if(mainBusinessCode != null && !"".equals(mainBusinessCode)) {
			MainBusiness getMainBusiness = mainBusinessService.getMainBusinessDetail(mainBusinessCode);
			model.addAttribute("getMainBusiness", getMainBusiness);
		}
		
		model.addAttribute("SectionTitle", "사업장 상세: 수정");
		model.addAttribute("mainBusinessCode", mainBusinessCode);
		return "mainBusiness/business_modify";
	}
	//사업장 정보 수정
	@PostMapping("/modify/{mainBusinessCode}")
	public String modifyMainBusiness(MainBusiness mainBusiness) {
		mainBusinessService.modifyMainBusiness(mainBusiness);
		
		 return "redirect:/k1Business/businessList";
	}
	//사업장 삭제
	@GetMapping("/mainBusinessDelete")
	public String mainBusinessDelete() {
		return "mainBusiness/business_list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
