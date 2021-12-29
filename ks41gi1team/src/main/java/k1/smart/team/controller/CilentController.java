package k1.smart.team.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.Stock;
import k1.smart.team.service.StockService;

@Controller
@RequestMapping(value="/k1Stock")
public class CilentController {
	private StockService stockService;
	private String mainBusinessCode;
	
	public CilentController(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping("")
	public String stockMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<Stock> stockList = stockService.getAllStockList(mainBusinessCode);
		
		model.addAttribute("title", "재고관리");
		model.addAttribute("stockList", stockList);
		return "stock/stock_list";
	}
}
