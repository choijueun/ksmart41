package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.StockService;

@Controller
public class StockController {
	private final StockService stockService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //사업장대표코드 임시지정
	private Stock stockInfo; //재고정보
	private List<Stock> stockList; //재고 배열
	private Map<String, Object> resultMap;
	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	
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
	 */
	@GetMapping("/k1Stock")
	public String stockMain(Model model) {
		//재고 전체목록 List<Stock>
		stockList = stockService.getAllStockList(mainBusinessCode);
		log.info("재고 LIST :: {}", stockList);
		model.addAttribute("stockList", stockList);
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "전체목록");
		return "stock/stock_list.html";
	}
	
	/**
	 * 재고 상세정보 조회
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1Stock/{inventoryCode}")
	public String stockInfo(
			@PathVariable(value="inventoryCode", required=false) String inventoryCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(inventoryCode)) return "redirect:/k1Stock";
		log.info("INVENTORY CODE :: {}", inventoryCode);
		
		//재고 상세정보 조회결과
		resultMap = stockService.getStockInfo(mainBusinessCode, inventoryCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Stock";
		
		//재고 한줄정보 Stock
		stockInfo = (Stock) resultMap.get("stockInfo");
		log.info("재고 INFO :: {}", stockInfo);
		model.addAttribute("s", stockInfo);
		//재고 물류이동내역 List<Storing>
		model.addAttribute("storingList", resultMap.get("storingList"));
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "재고정보");
		
		return "stock/stock_info";
	}
}
