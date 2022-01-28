package k1.smart.team.controller.psb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.service.cje.ItemService;
import k1.smart.team.service.csh.ClientService;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.UserService;
import k1.smart.team.service.psb.ContractService;
import k1.smart.team.service.psb.MaterialOrderService;
import k1.smart.team.service.psb.ProductOrderService;



@Controller
@RequestMapping(value="/k1MaterialOrder")
public class MaterialOrderController {
		
	private static final Logger log = LoggerFactory.getLogger(MaterialOrderController.class);
	
		private MaterialOrderService materialOrderService;
		private ClientService clientService;
		private MainBusinessService mainBusinessService;
		private UserService userService;
		private ItemService itemService;
		private ContractService contractService;
		private ProductOrderService productOrderService;
		private MaterialOrder materialOrderInfo; // 발주 하나 정보
		private Map<String, Object> paramMap;
		private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		
		
		//생성자 메서드
		public MaterialOrderController(MaterialOrderService materialOrderService, ClientService clientService, ItemService itemService, MainBusinessService mainBusinessService, UserService userService, ContractService contractService, ProductOrderService productOrderService) {
			this.materialOrderService = materialOrderService;
			this.clientService = clientService;
			this.itemService = itemService;
			this.mainBusinessService = mainBusinessService;
			this.userService = userService;
			this.contractService = contractService;
			this.productOrderService = productOrderService;
			
		}
		
		//발주 등록
		@PostMapping("/k1MaterialOrderReg")
		public String addMaterialOrder(MaterialOrder materialOrder) {
			
			System.out.println("MaterialOrderController 발주등록 화면에서 입력받은 값:" + materialOrder);
			//insert 처리
			//null 체크
			String materialOrderCode = materialOrder.getMaterialOrderCode();
			if(materialOrderCode != null && !"".equals(materialOrderCode)) {
				materialOrderService.addMaterialOrder(materialOrder);
			}
			return "redirect:/k1MaterialOrder/k1MaterialOrderList";
			
		}
		
		//발주 등록
		@GetMapping("/k1MaterialOrderReg")
		public String addOrder(Model model) {
  
			  System.out.println("/addContract GET 방식 요청"); 
			  model.addAttribute("title","발주서 등록");
		
			  
			  //DB 계약코드 LIST List<Contract> contractList =
			  List<MaterialOrder> materialOrderList =  materialOrderService.getMaterialOrderList(mainBusinessCode);
			  model.addAttribute("materialOrderList", materialOrderList);
			  System.out.println("materialOrderList: " + materialOrderList);
			 
			  
			List<Client> clientList = clientService.getAllClientList();
			  model.addAttribute("clientList", clientList);
			  System.out.println("clientList: " + clientList);
			  
			  List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
			  model.addAttribute("mainBusinessList", mainBusinessList);
			  System.out.println("mainBusinessList" + mainBusinessList);
			  
			  List<Contract> contractList = contractService.getContractHistoryList(mainBusinessCode);
			  model.addAttribute("contractList", contractList);
			  System.out.println("contractList" + contractList);
			  
			  List<Contract> contractCodeForMaterialOrderCodeList = contractService.getContractCodeForMaterialOrderCodeList();
			  model.addAttribute("contractCodeForMaterialOrderCodeList", contractCodeForMaterialOrderCodeList);
			  System.out.println("contractCodeForMaterialOrderCodeList" + contractCodeForMaterialOrderCodeList);
			  
			  List<User> userList = userService.getAllUserList();
			  model.addAttribute("userList", userList);
			  System.out.println("userList" + userList);
			
			  String getMaterialOrderCode = materialOrderService.getMaterialOrderCode();
			  model.addAttribute("getMaterialOrderCode", getMaterialOrderCode);
			  
			return "materialOrder/materialOrder_register";
		}
		
		//발주 수정 	
		@GetMapping("/modify/{materialOrderCode}")
		public String modifyMaterialOrder(
				@RequestParam(value="materialOrderCode", required=false) String materialOrderCode
				,Model model) {
			
			//materialOrderCode 콘솔에 출력(log4j)
			log.info("modifyMaterialOrder materialOrderCode: {}", materialOrderCode);
	
			
			MaterialOrder materialOrderInfo = materialOrderService.getMaterialOrderInfo(materialOrderCode);
			model.addAttribute("materialOrderInfo", materialOrderInfo);
			System.out.println("materialOrderInfo-->" + materialOrderInfo);
			
	
			//발주 정보
			if(materialOrderCode != null && !"".equals(materialOrderCode)) {
				 MaterialOrder materialOrderInfo1 = materialOrderService.getMaterialOrderInfo(materialOrderCode);
				model.addAttribute("materialOrderInfo1", materialOrderInfo1);
				System.out.println("materialOrderInfo1-->" + materialOrderInfo1);
			}		
						
			List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderList();
			  model.addAttribute("materialOrderList", materialOrderList);
			  System.out.println("materialOrderList" + materialOrderList);	
			
			 List<MainBusiness> mainBusinessList = mainBusinessService.getAllMainBusinessList();
			  model.addAttribute("mainBusinessList", mainBusinessList);
			  System.out.println("mainBusinessList" + mainBusinessList);
			  
			  List<Stock> itemList = itemService.getAllItemList(paramMap);
			  
			  model.addAttribute("itemList", itemList);
			  System.out.println("itemList" + itemList);
			  
			  
			  List<Contract> contractCodeForMaterialOrderCodeList = contractService.getContractCodeForMaterialOrderCodeList();
			  model.addAttribute("contractCodeForMaterialOrderCodeList", contractCodeForMaterialOrderCodeList);
			  System.out.println("contractCodeForMaterialOrderCodeList" + contractCodeForMaterialOrderCodeList);
			  
			  List<Contract> contractList = contractService.getAllContractList();
			  model.addAttribute("contractList", contractList);
			  System.out.println("contractList" + contractList);
			  
			  List<Client> clientList = clientService.getAllClientList();
			  model.addAttribute("clientList", clientList);
			  System.out.println("clientList: " + clientList);
			  
			  List<User> userList = userService.getAllUserList();
			  model.addAttribute("userList", userList);
			  System.out.println("userList" + userList);
			  
			 System.out.println("materialOrderInfo 컨트롤러-->" + materialOrderInfo);
			System.out.println("materialOrderCode-->" + materialOrderCode);
			model.addAttribute("title", "발주관리: 수정");
			model.addAttribute("materialOrderCode", materialOrderCode);
			
			return "materialOrder/materialOrder_modify";
		}
		
		//발주 정보 수정
		@PostMapping("/modify/{materialOrderCode}")
		public String modifyMaterialOrder(MaterialOrder materialOrder) {
			materialOrderService.modifyMaterialOrder(materialOrder);
			System.out.println("materialOrder-->" + materialOrder);
			 return "redirect:/k1MaterialOrder/k1MaterialOrderList";
		}
		
		
	
		
		//발주 코드 체크
		@PostMapping("/k1MaterialOrderCodeCheck")
		@ResponseBody
		public boolean materialOrderCodeCheck(@RequestParam(value="materialOrderCode", required = false) String materialOrderCode) {
			
			System.out.println("ajax 통신으로 요청받은 파라미터 materialOrderCode:" + materialOrderCode);
			
			boolean checkResult = false;
			
			int check = materialOrderService.getMaterialOrderByMaterialOrderCode(materialOrderCode);
			
			if(check > 0) checkResult = true;
			System.out.println("checkResult" + checkResult);
			return checkResult;
		}
	
	  //발주관리 상세
	  @GetMapping("/materialOrder/{materialOrderCode}") 
	  public String materialOrderInfo(
			  	@PathVariable(value="materialOrderCode", required=false) String materialOrderCode
			  	,Model model) { 
		  	//발주관리 코드 검사 if(materialOrderCode == null
		  		System.out.println("materialOrderCode-->" + materialOrderCode);
			  if(materialOrderCode == null || "".equals(materialOrderCode)) { 
				  System.out.println("발주코드 ERROR"); 
				  return "redirect:/k1MaterialOrder/k1MaterialOrderList"; 
				  } 
			  
			  //발주관리 상세정보 
			  materialOrderInfo = materialOrderService.getMaterialOrderInfo(materialOrderCode);
			  System.out.println("materialOrderInfo----->>" + materialOrderInfo);
			  if(materialOrderInfo == null) {
				  System.out.println("발주관리코드 ERROR"); 
				  return"redirect:/k1MaterialOrder/k1MaterialOrderList"; 
			  }
			    	  
			  model.addAttribute("title", "발주관리 상세");
			  model.addAttribute("SectionTitle", "발주관리");
			  model.addAttribute("SectionLocation", "상세정보");
			  model.addAttribute("materialOrderInfo", materialOrderInfo);
			 
			  return "materialOrder/materialOrder_info";
		  }
	  

		//발주 전체 목록
		@GetMapping("/k1MaterialOrderList")
		public String materialOrderMain(Model model) {
			List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderList(mainBusinessCode);
			model.addAttribute("title", "수.발주 목록");
			model.addAttribute("materialOrderList", materialOrderList);
			System.out.println("materialOrderList-->" + materialOrderList);
			
			List<Client> clientList = clientService.getAllClientList();
			model.addAttribute("clientList", clientList);
			System.out.println("clientList-->" + clientList);
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mainBusinessCode", mainBusinessCode);
			List<Stock> itemList = itemService.getAllItemList(paramMap);
			model.addAttribute("itemList", itemList);
			System.out.println("itemList-->" + itemList);
			
			List<ProductOrder> productOrderList = productOrderService.getProductOrderList();
			model.addAttribute("productOrderList", productOrderList);
			System.out.println("productOrderList-->" + productOrderList);
			
			return "materialOrder/materialOrder_list";
		}
		
		 @PostMapping("/k1MaterialOrderList")
		  @ResponseBody
		  public  List<MaterialOrder> contractMain(){
			  
			  List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderList();
			  System.out.println("controller materialOrderList--> " + materialOrderList);
			  return materialOrderList;
		  }
		
}
