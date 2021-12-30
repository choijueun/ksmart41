package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.StockService;

@Controller
@RequestMapping(value="/k1Stock")
public class StockController {
	private StockService stockService;
	private String mainBusinessCode;
	private List<Stock> stockList;
	private Stock stockInfo;
	
	//생성자 메서드
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	//재고 전체목록 조회
	@GetMapping("")
	public String stockMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		stockList = stockService.getAllStockList(mainBusinessCode);
		model.addAttribute("title", "재고관리");
		model.addAttribute("stockList", stockList);
		return "stock/stock_list";
	}
	
	//재고 상세정보 조회
	@GetMapping("/{inventoryCode}")
	public String stockInfo(
			@PathVariable(value="inventoryCode", required=false) String inventoryCode
			,Model model) {
		stockInfo = stockService.getStockInfoById(inventoryCode);
		System.out.println("StockController :: "+ stockInfo);
		
		if(stockInfo == null) {
			return "redirect:/k1Stock";
		}
		model.addAttribute("title", "재고정보");
		model.addAttribute("inventoryCode", inventoryCode);
		return "stock/stock_info";
	}
}
