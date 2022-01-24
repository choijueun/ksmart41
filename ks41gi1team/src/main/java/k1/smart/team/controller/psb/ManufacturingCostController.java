package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import k1.smart.team.dto.psb.ManufacturingCost;

import k1.smart.team.service.psb.ManufacturingCostService;
import k1.smart.team.common.CommonUtils;



@Controller
@RequestMapping(value="/k1ManufacturingCost")
public class ManufacturingCostController {
	private ManufacturingCostService manufacturingCostService;
	private List<ManufacturingCost> manufacturingCostList;

	public ManufacturingCostController(ManufacturingCostService manufacturingCostCalcService) {
		this.manufacturingCostService = manufacturingCostCalcService;
	}
		
	@GetMapping("/k1ManufacturingCostList")
	public String k1ManufacturingCostMain(Model model) {
		
		  List<ManufacturingCost> manufacturingCostList = manufacturingCostService.getManufacturingCostList();
		  model.addAttribute("title", "제조원가");
		  model.addAttribute("manufacturingCostList", manufacturingCostList);		
		  System.out.println("manufacturingCostList" + manufacturingCostList);
		
		  
		  if(CommonUtils.isEmpty(manufacturingCostList)) {
			  
			  System.out.println("manufacturingCostList"+ manufacturingCostList +"컨트롤러 null이다.");
			  // 널(null)이거나 공백(빈칸)일 경우 실행
			  
		  } else {
			 System.out.println("manufacturingCostList"+ manufacturingCostList +"컨트롤러 null이 아니다.");
			  // 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
			  
		  }
		  return "manufacturingCost/manufacturingCost_list";
	}
}
