package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.psb.PurchaseTransaction;
import k1.smart.team.dto.psb.SalesTransaction;
import k1.smart.team.service.psb.PurchaseTransactionService;
import k1.smart.team.service.psb.SalesTransactionService;

@Controller
@RequestMapping(value="/k1PurchaseTransaction")
public class PurchaseTransactionController {

	private PurchaseTransactionService purchaseTransactionService;
	private SalesTransactionService salesTransactionService;
	private String mainBusinessCode;
	private PurchaseTransaction purchaseTransactionInfo;
	private List<PurchaseTransaction> purchaseTransactionInfoList;
	private Map<String, Object> resultMap;
	
	public PurchaseTransactionController(PurchaseTransactionService purchaseTransactionService, SalesTransactionService salesTransactionService) {
		this.purchaseTransactionService = purchaseTransactionService;
		this.salesTransactionService = salesTransactionService;
	}
	
	//비용상세
	  @GetMapping("purchaseTransaction/{purchaseTsCode}") 
	  public String purchaseTransactionInfo(
			  	@PathVariable(value="purchaseTsCode", required=false) String purchaseTsCode
			  	,Model model) { 
		  	//비용거래서 코드 검사 if(purchaseTransactionCode == null
		  		System.out.println("purchaseTransactionCode-->" + purchaseTsCode);
			  if(purchaseTsCode == null || "".equals(purchaseTsCode)) { 
				  System.out.println("비용거래서코드 ERROR"); 
				  return "redirect:/k1PurchaseTransaction/k1PurchaseTransactionHistory"; 
				  } 
			  
			  //비용거래서 상세정보 
			  purchaseTransactionInfo = purchaseTransactionService.getPurchaseTransactionInfoByCode(purchaseTsCode);
			  if(purchaseTransactionInfo == null) {
				  System.out.println("비용거래서코드 ERROR"); 
				  return"redirect:/k1MaterialOrder/k1MaterialOrderList"; 
			  }
			    
			  model.addAttribute("title", "비용관리명세서 상세");
			  model.addAttribute("SectionTitle", "비용거래명세서 관리");
			  model.addAttribute("SectionLocation", "상세정보");
			  model.addAttribute("purchaseTransactionInfo", purchaseTransactionInfo);
			  return "purchaseTransaction/purchaseTransaction_info";
		  }
		
	//비용 거래명세서 등록
		@PostMapping("/k1PurchaseTransactionReg")
		public String addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
			
			System.out.println("PurchaseTransactionController 등록화면에서 입력받은 값:" + purchaseTransaction);
			//insert처리
			//null 체크
			String purchaseTsCode = purchaseTransaction.getPurchaseTsCode();
			if(purchaseTsCode != null && !"".equals(purchaseTsCode)) {
				purchaseTransactionService.addPurchaseTransaction(purchaseTransaction);
			}
			
			return "purchaseTransaction/purchaseTransaction_register";
		}
		
		@GetMapping("/k1PurchaseTransactionReg")
		public String addPurchaseTransaction(Model model) {
			System.out.println("/addPurchaseTransaction GET방식요청");
			model.addAttribute("title", "비용 거래 명세서 등록");
			
			List<PurchaseTransaction> purchaseTransactionList = purchaseTransactionService.getPurchaseTransactionList();
			model.addAttribute("purchaseTransactionList", purchaseTransactionList);
		
			String purchaseTransactionCode = purchaseTransactionService.getPurchaseTransactionCode();
			  model.addAttribute("purchaseTransactionCode", purchaseTransactionCode);
			
			return "purchaseTransaction/purchaseTransaction_register";
		}
		
	
	//전체 비용거래명세서 조회
	 @GetMapping("/k1PurchaseTransactionHistory") 
	  public String k1PurchaseTransactionHistory(Model model) {

		 List<PurchaseTransaction> purchaseTransactionList = purchaseTransactionService.getAllPurchaseTransactionList(mainBusinessCode);
		 
		  model.addAttribute("title", "비용/매출 거래명세서 목록");
		  model.addAttribute("purchaseTransactionList", purchaseTransactionList);
		  
		  List<SalesTransaction> salesTransactionList = salesTransactionService.getAllSalesTransactionList(mainBusinessCode);
		  model.addAttribute("salesTransactionList", salesTransactionList);
		  System.out.println("salesTransactionList" + salesTransactionList);
		  
		  return "purchaseTransaction/purchaseTransaction_history";
	  }
	  
	  @PostMapping("/k1PurchaseTransactionHistory")
	  @ResponseBody
	  public List<Map<String, Object>> purchaseTransactionMain(){
		  
		  List<Map<String, Object>> purchaseTransactionHistoryList = purchaseTransactionService.getPurchaseTransactionHistory();
		  
		  return purchaseTransactionHistoryList;
	  }
	
}
