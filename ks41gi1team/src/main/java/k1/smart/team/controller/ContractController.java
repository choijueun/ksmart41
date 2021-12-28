package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {

	@GetMapping("/k1ContractReg")
	public String addContract() {
		return "contract/contract_register";
	}
	
	@GetMapping("/k1ContractList")
	public String k1getAllContract() {
		return "contract/contract_list";
	}
	@GetMapping("/k1ContractDetail")
	public String k1getContract() {
		return "contract/contract_detail";
	}
}
