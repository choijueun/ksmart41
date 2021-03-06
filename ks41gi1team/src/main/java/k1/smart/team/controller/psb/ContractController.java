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
	
	//????????? ??????
	@GetMapping("/modify/{contractCode}")
	public String modifyMaterialOrder(
			@RequestParam(value="contractCode", required=false) String contractCode
			,Model model) {
		
		//materialOrderCode ????????? ??????(log4j)
		log.info("modifyContract contractCode: {}", contractCode);

		
		Contract contractInfo = contractService.getContractInfoByCode(contractCode);
		model.addAttribute("contractInfo", contractInfo);
		System.out.println("contractInfo-->" + contractInfo);
		

		//?????? ??????
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
		  
		model.addAttribute("title", "????????????: ??????");
		model.addAttribute("contractCode", contractCode);
		
		return "contract/contract_modify";
	}
	
	//????????? ??????
	@PostMapping("/modifyContract")
	public String modifyContract(Contract contract) {
		log.info("????????? ?????? ???????????? ?????? ?????? ??????????????? : {}" , contract);
	
		contractService.modifyContract(contract);
		
		return "redirect:/k1Contract/k1ContractHistory";
	}
	

	@GetMapping("/k1ContractDetail")
	public String k1getContract() {
		return "contract/contract_detail";
	}
	
	//????????? ?????? ??????
	@PostMapping("/k1ContractCodeCheck")
	@ResponseBody
	public boolean contractCodeCheck(@RequestParam(value="contractCode", required = false) String contractCode) {
		
		System.out.println("ajax ???????????? ???????????? ???????????? contractCode:" + contractCode);
		
		boolean checkResult = false;
		
		int check = contractService.getContractByContractCode(contractCode);
		
		if(check > 0) checkResult = true;
		
		return checkResult;
	}
	
	//????????? ???????????????
	@PostMapping("/k1ContractRegCheck")
	public Object contracts(@RequestBody Contract contract) {
		
		return null;
	}
	
	//????????? ??????
	@PostMapping("/k1ContractReg")
	public String addContract(Contract contract) {
		
		System.out.println("ContractController ????????? ???????????? ???????????? ???:" + contract);
		//insert ??????
		//null ??????
		String contractCode = contract.getContractCode();
		if(contractCode != null && !"".equals(contractCode)) {
			contractService.addContract(contract);
		}
		return "redirect:/k1Contract/k1ContractHistory";
		
	}
	
	  @GetMapping("/k1ContractReg") 
	  public String addContract(Model model) {

		  System.out.println("/addContract GET ?????? ??????"); 
		  model.addAttribute("title","????????? ??????");
	
		  
		  //DB ???????????? LIST List<Contract> contractList =
		  List<Contract> contractList =  contractService.getContractList(); 
		  model.addAttribute("contractList", contractList);
		  System.out.println("contractList: " + contractList);
		 
		  
		List<Client> clientList = clientService.getAllClientList(/*??????????????? mainBusinessCode */);
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
	 
	  //?????? ??????
		@GetMapping("/contract/{contractCode}")
		public String contractInfo(
				@PathVariable(value="contractCode", required=false) String contractCode
				,Model model) {
			if(contractCode == null || "".equals(contractCode)) {
				System.out.println("???????????? ERROR");
				return "redirect:/k1Contract/k1ContractHistory";
			}
			
			contractInfo = contractService.getContractInfoByCode(contractCode);
			if(contractInfo == null) {
				System.out.println("????????????info ERROR");
				return "redirect:/k1Contract/k1ContractHistory";
			}
			System.out.println("contractInfo" + contractInfo);
			model.addAttribute("title", "????????????: ????????????");
			model.addAttribute("contractInfo", contractInfo);
			return "contract/contract_detail";
		}	
	  
	  //?????? ?????? ??????
	  @GetMapping("/k1ContractList") 
	  public String contractMain(Model model) {
	
		  return "contract/contract_list";
	  }
	  
	  
	  @GetMapping("/k1ContractHistory") 
	  public String k1ContractHistory(Model model) {

		  mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		  List<Contract> contractList = contractService.getContractHistoryList(mainBusinessCode);
		  model.addAttribute("title", "????????????");
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