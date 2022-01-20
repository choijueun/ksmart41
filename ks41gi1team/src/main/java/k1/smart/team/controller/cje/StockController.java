package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		stockList = stockService.getAllStockList(null, null, mainBusinessCode);
		log.info("재고 LIST :: {}", stockList);
		model.addAttribute("stockList", stockList);
		
		model.addAttribute("wList", stockService.getAllWarehouseList(mainBusinessCode));
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "전체목록");
		return "stock/stock_list.html";
	}
	
	@PostMapping("/k1Stock")
	public String stockMainAjax(Model model, 
			@RequestParam(value="types[]", required = false) List<String> types,
			@RequestParam(value="wares[]", required = false) List<String> wares) {
		String typeList = null;
		//분류 배열이 null이 아닐 때
		if(!CommonUtils.isEmpty(types)) {
			StringJoiner str = new StringJoiner("|");
			for(String i : types) {
				str.add(i);
			}
			typeList = str.toString();
		}
		String wList = null;
		//창고 배열이 null이 아닐 때
		if(!CommonUtils.isEmpty(wares)) {
			StringJoiner str = new StringJoiner("|");
			for(String i : wares) {
				str.add(i);
			}
			wList = str.toString();
		}
		/*
		 * log.info("선택한 분류 목록 :: {}",typeList);
		 * log.info("선택한 창고 목록 :: {}",wList);
		 */
		//재고 전체목록 List<Stock>
		stockList = stockService.getAllStockList(typeList, wList, mainBusinessCode);
		model.addAttribute("stockList", stockList);
		
		return "stock/stock_list_table.html";
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
	
	/**
	 * Ajax :: 재고 수량/중량 검사
	 * @param inventoryCode
	 */
	@GetMapping("/k1stockRemove")
	@ResponseBody
	public char stockRemoveValid(String inventoryCode) {
		char result = stockService.stockRemoveValid(mainBusinessCode, inventoryCode);
		return result;
	}
	
	@PostMapping("/k1StockRemove")
	public String removeStock(String inventoryCode) {
		stockService.removeStock(mainBusinessCode, inventoryCode);
		
		return "redirect:/k1Stock";
	}
}
