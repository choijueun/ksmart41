package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.dto.psb.SalesTransaction;
import k1.smart.team.service.psb.SalesTransactionService;



@Controller
@RequestMapping(value="/k1SalesTransaction")
public class SalesTransactionController {
	
	private SalesTransactionService salesTransactionService;
	private String mainBusinessCode;
	
	public SalesTransactionController(SalesTransactionService salesTransactionService) {
		this.salesTransactionService = salesTransactionService;
	}

	 //매출거래명세서 전체 조회
	  @GetMapping("/k1SalesTransactionHistory") 
	  public String k1SalesTransactionHistory(Model model) {

		  model.addAttribute("title", "매출 거래명세서 목록");

		  
		  return "salesTransaction/salesTransaction_history";
	  }
	  
	  @PostMapping("/k1SalesTransactionHistory")
	  @ResponseBody
	  public List<Map<String, Object>> salesTransactionMain(){
		  
		  List<Map<String, Object>> salesTransactionHistoryList = salesTransactionService.getSalesTransactionHistory();
		  
		  return salesTransactionHistoryList;
	  }
}	  