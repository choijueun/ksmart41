package k1.smart.team.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import k1.smart.team.dto.Contract;
import k1.smart.team.service.ContractService;


@Controller
public class ContractController {

	private ContractService contractService;
	
	public ContractController(ContractService contractService) {
		this.contractService = contractService;
	}
	
	@GetMapping("/k1ContractReg")
	public String k1addContract() {
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
	
	//전체계약서 검색
	@PostMapping("/contractList") 
	public String getSearchContractList( @RequestParam(value="searchKey", required = false) String searchKey
										,@RequestParam(value="searchValue", required = false)String searchValue
										,Model model) {
		System.out.println(searchKey);
		System.out.println(searchValue);
		
		if(searchKey != null && "contractCode".equals(searchKey)) {
		searchKey = "contractCode";
		}else if(searchKey != null && "mainBusinessCode".equals(searchKey)) {
		searchKey = "mainBusinessCode";
		  
		}else if(searchKey != null && "clientCode".equals(searchKey)) {
		searchKey = "clientCode";
		  
		}else if(searchKey != null && "clientManagerId".equals(searchKey)) {
		searchKey = "clientManagerId";
		
		}else if(searchKey != null && "contractSection".equals(searchKey)) {
		searchKey = "contractSection";
		
		}else if(searchKey != null && "contractType".equals(searchKey)) {
		searchKey = "contractType";
		
		}else if(searchKey != null && "startDate".equals(searchKey)) {
		searchKey = "startDate";
		
		}else if(searchKey != null && "endDate".equals(searchKey)) {
		searchKey = "endDate";
		
		}else if(searchKey != null && "managerId".equals(searchKey)) {
		searchKey = "managerId";
		
		}else if(searchKey != null && "regId".equals(searchKey)) {
		searchKey = "regId";
		
		}else if(searchKey != null && "approvalId".equals(searchKey)) {
		searchKey = "approvalId";
		
		}else if(searchKey != null && "contractDate".equals(searchKey)) {
		searchKey = "contractDate";
		
		}else if(searchKey != null && "contractStatus".equals(searchKey)) {
		searchKey = "contractStatus";
		
		}else if(searchKey != null && "briefs".equals(searchKey)) {
		searchKey = "briefs";
		
		}else if(searchKey != null && "regDate".equals(searchKey)) {
		searchKey = "regDate";
		
		}else {
			searchKey = "updateDate";
		}
		  // 검색키 검색어를 통해서 계약목록 조회
			System.out.println(searchKey);
			System.out.println(searchValue);
		  List<Contract> contractList = contractService.getContractListBySearchKey(searchKey, searchValue);
		  System.out.println(contractList);
		  // 조회된 회원목록 model에 값을 저장
		  model.addAttribute("title", "계약목록조회");
		  model.addAttribute("contractList", contractList);
		  
		  
		  return "contract/contract_view";
	  }
	  
	  @GetMapping("/contractList") 
	  public String getContractList(Model model) {
		  
		  List<Contract> contractList = contractService.getContractList();
		  model.addAttribute("title", "계약목록조회");
		  model.addAttribute("contractList", contractList);
		  
		  return "contract/contract_list";
	  }
	  /*
		 * ModelAndView (화면에 보내질 데이터 + 화면경로)
		 */
	
}
