package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.service.psb.PurchaseTransactionService;

@Controller
@RequestMapping(value="/k1PurchaseTransaction")
public class PurchaseTransactionController {

	private PurchaseTransactionService purchaseTransactionService;
	
	public PurchaseTransactionController(PurchaseTransactionService purchaseTransactionService) {
		this.purchaseTransactionService = purchaseTransactionService;
	}
	
	//전체 비용거래명세서 조회
	 @GetMapping("/k1PurchaseTransactionHistory") 
	  public String k1PurchaseTransactionHistory(Model model) {

		  model.addAttribute("title", "비용 거래명세서 목록");

		  
		  return "purchaseTransaction/purchaseTransaction_history";
	  }
	  
	  @PostMapping("/k1PurchaseTransactionHistory")
	  @ResponseBody
	  public List<Map<String, Object>> purchaseTransactionMain(){
		  
		  List<Map<String, Object>> purchaseTransactionHistoryList = purchaseTransactionService.getPurchaseTransactionHistory();
		  
		  return purchaseTransactionHistoryList;
	  }
	
}
