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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.service.cje.ItemService;
import k1.smart.team.service.csh.ClientService;
import k1.smart.team.service.psb.MaterialOrderService;


@Controller
@RequestMapping(value="/k1MaterialOrder")
public class MaterialOrderController {
		
	private static final Logger log = LoggerFactory.getLogger(MaterialOrderController.class);
	
		private MaterialOrderService materialOrderService;
		private ClientService clientService;
		private ItemService itemService;
		private String mainBusinessCode;
		private List<MaterialOrder> materialOrderInfoList;  //발주 상세정보
		private MaterialOrder materialOrderInfo; // 발주 하나 정보
		private Map<String,Object> resultMap;

		
		
		
		//생성자 메서드
		public MaterialOrderController(MaterialOrderService materialOrderService, ClientService clientService, ItemService itemService) {
			this.materialOrderService = materialOrderService;
			this.clientService = clientService;
			this.itemService = itemService;
		}
		
	
		@GetMapping("/k1MaterialOrderReg")
		public String addOrder() {
			return "materialOrder/materialOrder_register";
		}
		
		//발주 수정 	
		@GetMapping("/modify/{materialOrderCode}")
		public String modifyMaterialOrderInfo(
				@RequestParam(value="materialOrderCode", required=false) String materialOrderCode
				,Model model) {
			
			//materialOrderCode 콘솔에 출력(log4j)
			log.info("modifyMaterialOrder materialOrderCode: {}", materialOrderCode);
			
			MaterialOrder materialOrderInfo = materialOrderService.getMaterialOrderInfoByMaterialOrderCode(materialOrderCode);
			model.addAttribute("materialOrderInfo", materialOrderInfo);
			
			model.addAttribute("title", "발주관리: 수정");
			return "materialOrder/materialOrder_list";
		}
		
		
	
	  //발주관리 상세
	  @SuppressWarnings("unchecked")  
	  @GetMapping("materialOrder/{materialOrderCode}") 
	  public String materialOrderInfo(
			  	@PathVariable(value="materialOrderCode", required=false) String materialOrderCode
			  	,Model model) { 
		  	//발주관리 코드 검사 if(materialOrderCode == null
		  		System.out.println(materialOrderCode);
			  if(materialOrderCode == null || "".equals(materialOrderCode)) { 
				  System.out.println("발주코드 ERROR"); 
				  return "redirect:/k1MaterialOrder/materialOrder"; 
				  } 
			  
			  //발주관리 상세정보 
			  System.out.println("resultMap" + resultMap);
			  resultMap = materialOrderService.getMaterialOrderInfo(materialOrderCode);
			  if(resultMap == null) {
				  System.out.println("발주관리코드 ERROR"); 
				  return"redirect:/k1MaterialOrder/materialOrder"; 
			  }
			  
			  materialOrderInfo = (MaterialOrder) resultMap.get("materialOrderInfo");
	
			  materialOrderInfoList = (List<MaterialOrder>) resultMap.get("materialOrderInfoList");

			  
			  model.addAttribute("title", "발주관리 상세");
			  model.addAttribute("SectionTitle", "발주관리");
			  model.addAttribute("SectionLocation", "상세정보");
			  model.addAttribute("materialOrderInfo", materialOrderInfo);
			  model.addAttribute("materialOrderInfoList", materialOrderInfoList); 
			  return "materialOrder/materialOrder_info";
		  }
	 
		
		
		
		
		//발주 전체 목록
		@GetMapping("/k1MaterialOrderList")
		public String materialOrderMain(Model model) {
			mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
			List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderList(mainBusinessCode);
			model.addAttribute("title", "발주목록");
			model.addAttribute("materialOrderList", materialOrderList);
			
			List<Client> clientList = clientService.getAllClientList();
			model.addAttribute("clientList", clientList);
			System.out.println("clientList" + clientList);
			
			List<Stock> itemList = itemService.getAllItemList(mainBusinessCode);
			model.addAttribute("itemList", itemList);
			System.out.println("itemList" + itemList);
			
			return "materialOrder/materialOrder_list";
		}
}
