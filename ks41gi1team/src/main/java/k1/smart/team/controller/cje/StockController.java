package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StockService;

@Controller
public class StockController {
	private StockService stockService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드 임시지정
	private List<Stock> stockList; //재고 배열
	private Stock stockInfo; //재고 하나 정보
	private List<Storing> storingList; //재고조정내역 상세정보
	private Map<String, Object> resultMap;
	
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
	@GetMapping("/k1Stock")
	public String stockMain(Model model) {
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
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Stock/{inventoryCode}")
	public String stockInfo(
			@PathVariable(value="inventoryCode", required=false) String inventoryCode
			,Model model) {
		//재고코드 검사
		if(inventoryCode == null || "".equals(inventoryCode)) return "redirect:/k1Stock";
		
		//재고 상세정보
		resultMap = stockService.getStockInfo(mainBusinessCode, inventoryCode);
		if(resultMap == null) return "redirect:/k1Stock";
		
		stockInfo = (Stock) resultMap.get("stockInfo");
		storingList = (List<Storing>) resultMap.get("storingList");
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "재고정보");
		model.addAttribute("s", stockInfo);
		model.addAttribute("storingList", storingList);
		return "stock/stock_info";
	}
}
