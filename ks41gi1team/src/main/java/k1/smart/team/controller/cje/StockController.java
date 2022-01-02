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
	private String mainBusinessCode; //사업장대표코드
	private List<Stock> stockList; //재고 배열
	private Stock stockInfo; //재고 하나 정보
	
	/**
	 * 생성자 메서드
	 * @param stockService
	 */
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	/**
	 * 재고 전체목록 조회
	 * @param model
	 * @return stock_list (List<Stock>)
	 */
	@GetMapping("")
	public String stockMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		//재고 전체목록
		stockList = stockService.getAllStockList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("stockList", stockList);
		return "stock/stock_list";
	}
	
	/**
	 * 재고 상세정보 조회
	 * @param inventoryCode
	 * @param model
	 * @return stock_info (Stock)
	 */
	@GetMapping("/{inventoryCode}")
	public String stockInfo(
			@PathVariable(value="inventoryCode", required=false) String inventoryCode
			,Model model) {
		if(inventoryCode == null || "".equals(inventoryCode)) {
			System.out.println("재고코드 ERROR");
			return "redirect:/k1Stock";
		}
		
		//재고 상세정보
		stockInfo = stockService.getStockInfoByCode(inventoryCode);
		//System.out.println("StockController :: "+ stockInfo);
		if(stockInfo == null) {
			System.out.println("재고코드 ERROR");
			return "redirect:/k1Stock";
		}
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "재고정보");
		model.addAttribute("stockInfo", stockInfo);
		return "stock/stock_info";
	}
}
