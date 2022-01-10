package k1.smart.team.controller.psb;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.ClientService;
import k1.smart.team.service.psb.ContractService;



@Controller
@RequestMapping(value="/k1Contract")

public class ContractController {

	private ContractService contractService;
	private String mainBusinessCode;
	private ClientService clientService;
	private MainBusinessService mainBusinessService;
	
	public ContractController(ContractService contractService, ClientService clientService, MainBusinessService mainBusinessService) {
		this.contractService = contractService;
		this.clientService = clientService;
		this.mainBusinessService = mainBusinessService;
	}
	
	
	
	
	/*
	 * @GetMapping("/k1ContractReg") public String k1addContract() { return
	 * "contract/contract_register"; }
	 */
	
	/*
	 * @GetMapping("/k1ContractList") public String k1getAllContract() { return
	 * "contract/contract_list"; }
	 */
	@GetMapping("/k1ContractDetail")
	public String k1getContract() {
		return "contract/contract_detail";
	}
	
	//계약서 코드 체크
	@PostMapping("/k1ContractCodeCheck")
	@ResponseBody
	public boolean contractCodeCheck(@RequestParam(value="contractCode", required = false) String contractCode) {
		
		System.out.println("ajax 통신으로 요청받은 파라미터 contractCode:" + contractCode);
		
		boolean checkResult = false;
		
		int check = contractService.getContractByContractCode(contractCode);
		
		if(check > 0) checkResult = true;
		
		return checkResult;
	}
	
	//계약서 등록
	@PostMapping("/k1ContractReg")
	public String addContract(Contract contract) {
		
		System.out.println("ContractController 회원등록 화면에서 입력받은 값:" + contract);
		//insert 처리
		//null 체크
		String contractCode = contract.getContractCode();
		if(contractCode != null && !"".equals(contractCode)) {
			contractService.addContract(contract);
		}
		
		return "contract/contract_register";
		
	}
	
	  @GetMapping("/k1ContractReg") 
	  public String addContract(Model model) {

		 	  

		/* 최선희 수정
		 * mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		 */		  

		  System.out.println("/addContract GET 방식 요청"); 
		  model.addAttribute("title","계약서 등록");
	
		  
		  //DB 계약코드 LIST List<Contract> contractList =
		  List<Contract> contractList =  contractService.getContractList(); 
		  model.addAttribute("contractList", contractList);
		  System.out.println("contractList: " + contractList);
		 
		  
		List<Client> clientList = clientService.getAllClientList(/*최선희수정 mainBusinessCode */);
		  model.addAttribute("clientList", clientList);
		  System.out.println("clientList: " + clientList);
		  
		  List<MainBusiness> mainBusinessesList = mainBusinessService.getAllMainBusinessList();
		  model.addAttribute("mainBusinessesList", mainBusinessesList);
		  System.out.println("mainBusinessesList" + mainBusinessesList);
		  
		  String contractInfo = contractService.getContractInfo();
		  model.addAttribute("contractInfo", contractInfo);
		  
		  
		  return "contract/contract_register"; 
	  
	  }
	 
	
	//하나의 계약서 검색
	@PostMapping("/k1ContractOne") 
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
		  model.addAttribute("title", "계약목록");
		  model.addAttribute("contractList", contractList);
		  
		  
		  return "contract/contract_list";
	  }
	  
	  //계약 전체 목록
	  @GetMapping("/k1ContractList") 
	  public String contractMain(Model model) {
		  mainBusinessCode = "fac_ksmartSeoul_Seoul001";
		  List<Contract> contractList = contractService.getAllContractList(mainBusinessCode);
		  model.addAttribute("title", "계약목록");
		  model.addAttribute("contractList", contractList);
		  

		  
		  return "contract/contract_list";
	  }
	  
	  
	  @GetMapping("/k1ContractHistory") 
	  public String k1ContractHistory(Model model) {

		  model.addAttribute("title", "계약목록");

		  
		  return "contract/contract_history";
	  }
	  
	  @PostMapping("/k1ContractHistory")
	  @ResponseBody
	  public List<Map<String, Object>> contractMain(){
		  
		  List<Map<String, Object>> contractHistoryList = contractService.getContractHistory();
		  
		  return contractHistoryList;
	  }
	  
	  /*
		 * ModelAndView (화면에 보내질 데이터 + 화면경로)
		 */
	
}
