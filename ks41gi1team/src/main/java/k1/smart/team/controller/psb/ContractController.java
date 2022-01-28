package k1.smart.team.controller.psb;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ContractCodeForMaterialOrderCode;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.service.cje.ItemService;
import k1.smart.team.service.csh.ClientService;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.UserService;
import k1.smart.team.service.psb.ContractService;
import k1.smart.team.service.psb.MaterialOrderService;



@Controller
@RequestMapping(value="/k1Contract")

public class ContractController {


	private static final Logger log = LoggerFactory.getLogger(ContractController.class);

	private ContractService contractService;
	private ItemService itemService;
	private String mainBusinessCode;
	private ClientService clientService;
	private MainBusinessService mainBusinessService;
	private UserService userService;
	private Contract contractInfo;
	private String contractCode;

	private Map<String, Object> paramMap;

	
	public ContractController(ContractService contractService, ClientService clientService, ItemService itemService, MainBusinessService mainBusinessService, UserService userService) {
		this.contractService = contractService;
		this.clientService = clientService;
		this.mainBusinessService = mainBusinessService;
		this.userService = userService;
		this.itemService = itemService;
		this.userService = userService;
	}
	
	//계약서 수정
	@GetMapping("/modify/{contractCode}")
	public String modifyMaterialOrder(
			@RequestParam(value="contractCode", required=false) String contractCode
			,Model model) {
		
		//materialOrderCode 콘솔에 출력(log4j)
		log.info("modifyContract contractCode: {}", contractCode);

		
		Contract contractInfo = contractService.getContractInfoByCode(contractCode);
		model.addAttribute("contractInfo", contractInfo);
		System.out.println("contractInfo-->" + contractInfo);
		

		//계약 정보
		if(contractCode != null && !"".equals(contractCode)) {
			Contract contractInfo1 = contractService.getContractInfoByCode(contractCode);
			model.addAttribute("contractInfo1", contractInfo1);
			System.out.println("contractInfo1-->" + contractInfo1);
		}		
					
		List<Contract> contractList = contractService.getAllContractList();
		  model.addAttribute("contractList", contractList);
		  System.out.println("contractList" + contractList);	
		
		
		
		 List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
		  model.addAttribute("mainBusinessList", mainBusinessList);
		  System.out.println("mainBusinessList" + mainBusinessList);
		  
		  List<Stock> itemList = itemService.getAllItemList(paramMap);
		  model.addAttribute("itemList", itemList);
		  System.out.println("itemList" + itemList);
		  
		  List<Client> clientList = clientService.getAllClientList();
		  model.addAttribute("clientList", clientList);
		  System.out.println("clientList: " + clientList);
		  
		  List<User> userList = userService.getAllUserList();
		  model.addAttribute("userList", userList);
		  System.out.println("userList" + userList);
		  
		model.addAttribute("title", "계약관리: 수정");
		model.addAttribute("contractCode", contractCode);
		
		return "contract/contract_modify";
	}
	
	//계약서 수정
	@PostMapping("/modifyContract")
	public String modifyContract(Contract contract) {
		log.info("계약서 수정 화면에서 입력 받은 계약서정보 : {}" , contract);
	
		contractService.modifyContract(contract);
		
		return "redirect:/k1Contract/k1ContractHistory";
	}
	

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
	
	//계약서 유효성검사
	@PostMapping("/k1ContractRegCheck")
	public Object contracts(@RequestBody Contract contract) {
		
		return null;
	}
	
	//계약서 등록
	@PostMapping("/k1ContractReg")
	public String addContract(Contract contract) {
		
		System.out.println("ContractController 계약서 화면에서 입력받은 값:" + contract);
		//insert 처리
		//null 체크
		String contractCode = contract.getContractCode();
		if(contractCode != null && !"".equals(contractCode)) {
			contractService.addContract(contract);
		}
		return "redirect:/k1Contract/k1ContractHistory";
		
	}
	
	  @GetMapping("/k1ContractReg") 
	  public String addContract(Model model) {

		  System.out.println("/addContract GET 방식 요청"); 
		  model.addAttribute("title","계약서 등록");
	
		  
		  //DB 계약코드 LIST List<Contract> contractList =
		  List<Contract> contractList =  contractService.getContractList(); 
		  model.addAttribute("contractList", contractList);
		  System.out.println("contractList: " + contractList);
		 
		  
		List<Client> clientList = clientService.getAllClientList(/*최선희수정 mainBusinessCode */);
		  model.addAttribute("clientList", clientList);
		  System.out.println("clientList: " + clientList);
		  
		  List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
		  model.addAttribute("mainBusinessList", mainBusinessList);
		  System.out.println("mainBusinessList" + mainBusinessList);
		  
		  List<User> userList = userService.getAllUserList();
		  model.addAttribute("userList", userList);
		  System.out.println("userList" + userList);
		  
		  String contractCode = contractService.getContractCode();
		  model.addAttribute("contractCode", contractCode);
		  
		
		  List <Contract> contractCodeForMaterialOrderCodeList = contractService.getContractCodeForMaterialOrderCodeList();
		  model.addAttribute("contractCodeForMaterialOrderCodeList",contractCodeForMaterialOrderCodeList);
		  System.out.println("contractCodeForMaterialOrderCodeList" + contractCodeForMaterialOrderCodeList);

		  List <Contract> contractCodeForProductOrderCodeList = contractService.getContractCodeForProductOrderCodeList();
		  model.addAttribute("contractCodeForProductOrderCodeList",contractCodeForProductOrderCodeList);
		  System.out.println("contractCodeForProductOrderCodeList" + contractCodeForProductOrderCodeList);

		  
		  return "contract/contract_register"; 
	  
	  }
	 
	  //계약 상세
		@GetMapping("/contract/{contractCode}")
		public String contractInfo(
				@PathVariable(value="contractCode", required=false) String contractCode
				,Model model) {
			if(contractCode == null || "".equals(contractCode)) {
				System.out.println("계약코드 ERROR");
				return "redirect:/k1Contract/k1ContractHistory";
			}
			
			contractInfo = contractService.getContractInfoByCode(contractCode);
			if(contractInfo == null) {
				System.out.println("계약코드info ERROR");
				return "redirect:/k1Contract/k1ContractHistory";
			}
			System.out.println("contractInfo" + contractInfo);
			model.addAttribute("title", "계약상세: 상세정보");
			model.addAttribute("contractInfo", contractInfo);
			return "contract/contract_detail";
		}	
	  
	  //계약 전체 목록
	  @GetMapping("/k1ContractList") 
	  public String contractMain(Model model) {
	
		  return "contract/contract_list";
	  }
	  
	  
	  @GetMapping("/k1ContractHistory") 
	  public String k1ContractHistory(Model model) {

		  mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		  List<Contract> contractList = contractService.getContractHistoryList(mainBusinessCode);
		  model.addAttribute("title", "계약목록");
		  model.addAttribute("contractList", contractList);
		  System.out.println("History contractList" + contractList);
		  
		  return "contract/contract_history";
	  }
	  
	  @PostMapping("/k1ContractHistory")
	  @ResponseBody
	  public  List<Contract> contractMain(){
		  
		  List<Contract> contractHistoryList = contractService.getContractHistoryList(mainBusinessCode);
		  System.out.println("controller contractHistoryList: " + contractHistoryList);
		  System.out.println(contractCode);
		  return contractHistoryList;
	  }
	  
	
	
}