package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ManufacturingCostCalc;
import k1.smart.team.service.psb.ManufacturingCostCalcService;
import k1.smart.team.common.CommonUtils;



@Controller
@RequestMapping(value="/k1ManufacturingCostCals")
public class ManufacturingCostCalcController {
	private ManufacturingCostCalcService manufacturingCostCalcService;
	private String materialCode;
	public ManufacturingCostCalcController(ManufacturingCostCalcService manufacturingCostCalcService) {
		this.manufacturingCostCalcService = manufacturingCostCalcService;
	}
		
	@GetMapping("/k1ManufacturingCostCalsList")
	public String k1ManufacturingCostCalcMain(Model model) {
		
		  List<ManufacturingCostCalc> manufacturingCostCalcList = manufacturingCostCalcService.getManufacturingCostCalcList();
		  model.addAttribute("title", "제조원가계산");
		  model.addAttribute("manufacturingCostCalcList", manufacturingCostCalcList);		
		  System.out.println("manufacturingCostCalcList" + manufacturingCostCalcList);
		
		  
		  if(CommonUtils.isEmpty(manufacturingCostCalcList)) {
			  
			  System.out.println("manufacturingCostCalcList"+ manufacturingCostCalcList +"컨트롤러 null이다.");
			  // 널(null)이거나 공백(빈칸)일 경우 실행
			  
		  } else {
			 System.out.println("manufacturingCostCalcList"+ manufacturingCostCalcList +"컨트롤러 null이 아니다.");
			  // 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
			  
		  }
		  return "manufacturingCostCalc/manufacturingCostCalc_list";
	}
}
