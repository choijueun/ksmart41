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

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.SalesTransaction;
import k1.smart.team.service.psb.SalesTransactionService;

@Controller
@RequestMapping(value="/k1SalesTransaction")
public class SalesTransactionController {
	
	private SalesTransactionService salesTransactionService;
	private String mainBusinessCode;
	private SalesTransaction salesTransactionInfo;
	
	public SalesTransactionController(SalesTransactionService salesTransactionService) {
		this.salesTransactionService = salesTransactionService;
	}

	//매출거래명세서 등록
		@PostMapping("/k1SalesTransactionReg")
		public String addSalesTransaction(SalesTransaction salesTransaction) {
			
			System.out.println("SalesTransactionController 회원등록 화면에서 입력받은 값:" + salesTransaction);
			//insert 처리
			//null 체크
			String salesTsCode = salesTransaction.getSalesTsCode();
			if(salesTsCode != null && !"".equals(salesTsCode)) {
				salesTransactionService.addSalesTransaction(salesTransaction);
			}
			
			return "salesTransaction/salesTransaction_register";
			
		}
		
		  @GetMapping("/k1SalesTransactionReg") 
		  public String addSalesTransaction(Model model) {
			  mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
			  
			  System.out.println("/addSalesTransaction GET 방식 요청"); 
			  model.addAttribute("title","매출 거래 명세서 등록");
		
			  
			  //DB 계약코드 LIST List<SalesTransaction> salesTransactionList =
			  List<SalesTransaction> salesTransactionList =  salesTransactionService.getSalesTransactionList(); 
			  model.addAttribute("salesTransactionList", salesTransactionList);
			  System.out.println("salesTransactionList: " + salesTransactionList);
			 
			  String salesTransactionCode = salesTransactionService.getSalesTransactionCode();
			  model.addAttribute("salesTransactionCode", salesTransactionCode);
			  System.out.println("salesTransactionCode" + salesTransactionCode);
			  
			  
			  return "salesTransaction/salesTransaction_register"; 
		  
		  }
	
	//매출거래명세서 상세정보
		  @GetMapping("/salesTransaction/{salesTsCode}")
			public String salesTransactionInfo(
					@PathVariable(value="salesTsCode", required=false) String salesTsCode
					,Model model) {
				if(salesTsCode == null || "".equals(salesTsCode)) {
					System.out.println("매출거래명세서코드 ERROR");
					return "redirect:/k1PurchaseTransaction/k1PurchaseTransactionHistory";
				}
				
				salesTransactionInfo = salesTransactionService.getSalesTransactionInfoByCode(salesTsCode);
				if(salesTransactionInfo == null) {
					System.out.println("비용코드 ERROR");
					return "redirect:/k1CostList";
				}
				model.addAttribute("title", "기타비용: 상세정보");
				model.addAttribute("salesTransactionInfo", salesTransactionInfo);
				return "salesTransaction/salesTransaction_info";
			}	
	
	
	 //매출거래명세서 전체 조회
	  @GetMapping("/k1SalesTransactionHistory") 
	  public String k1SalesTransactionHistory(Model model) {

		  List<SalesTransaction> salesTransactionList = salesTransactionService.getAllSalesTransactionList(mainBusinessCode);
		  model.addAttribute("title", "매출 거래명세서 목록");
		  model.addAttribute("salesTransactionList", salesTransactionList);
		  System.out.println("salesTransactionList-->" + salesTransactionList);
		  
		  return "salesTransaction/salesTransaction_history";
	  }
	  
	  @PostMapping("/k1SalesTransactionHistory")
	  @ResponseBody
	  public List<Map<String, Object>> salesTransactionMain(){
		  
		  List<Map<String, Object>> salesTransactionHistoryList = salesTransactionService.getSalesTransactionHistory();
		  
		  return salesTransactionHistoryList;
	  }
}	  