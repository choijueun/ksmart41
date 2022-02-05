package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import k1.smart.team.service.cje.WarehouseService;

@Controller
public class StockController {
	private final StockService stockService;
	private Stock stockInfo; //재고정보
	private List<Stock> stockList; //재고 배열
	private Map<String, Object> resultMap;
	
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	private WarehouseService warehouseService;
	
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
	public String stockMain(Model model, HttpSession session) {
		//재고 전체목록 List<Stock>
		stockList = stockService.getAllStockList(null, null, (String) session.getAttribute("MAINBUSINESSCODE"));
		log.info("재고 LIST :: {}", stockList);
		model.addAttribute("stockList", stockList);
		
		//사업장대표코드
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		model.addAttribute("wList", warehouseService.getAllWarehouseList(paramMap));
		
		model.addAttribute("SectionTitle", "재고관리");
		model.addAttribute("SectionLocation", "전체목록");
		return "stock/stock_list.html";
	}
	
	/**
	 * AJAX :: 특정 조건하에 재고 전체목록 조회 
	 * @param model
	 * @param types
	 * @param wares
	 * @return
	 */
	@PostMapping("/k1Stock")
	public String stockMainAjax(Model model, HttpSession session, 
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
		stockList = stockService.getAllStockList(typeList, wList, (String) session.getAttribute("MAINBUSINESSCODE"));
		model.addAttribute("stockList", stockList);
		
		return "stock/ajax/stock_list_table.html";
	}
	
	/**
	 * 재고 상세정보 조회
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1Stock/{inventoryCode}")
	public String stockInfo(
			@PathVariable(value="inventoryCode", required=false) String inventoryCode
			,Model model, HttpSession session) {
		//매개변수 검사
		if(CommonUtils.isEmpty(inventoryCode)) return "redirect:/k1Stock";
		
		//재고 상세정보 조회결과
		resultMap = stockService.getStockInfo((String) session.getAttribute("MAINBUSINESSCODE"), inventoryCode);
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
	 * Ajax :: 재고 수량·중량 검사
	 * @param inventoryCode
	 */
	@GetMapping("/checkStockRemove")
	@ResponseBody
	public char stockRemoveValid(String inventoryCode, HttpSession session) {
		char result = stockService.stockRemoveValid((String) session.getAttribute("MAINBUSINESSCODE"), inventoryCode);
		return result;
	}
	
	/**
	 * 수량·중량 0인 재고 모두 삭제
	 */
	@GetMapping("/k1CleanStock")
	public String cleanStock(HttpSession session) {
		stockService.cleanStock((String) session.getAttribute("MAINBUSINESSCODE"));
		
		return "redirect:/k1Stock";
	}
	
	/**
	 * 재고정보 삭제
	 * @param inventoryCode
	 */
	@PostMapping("/k1StockRemove")
	public String removeStock(String inventoryCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("inventoryCode", inventoryCode);
		stockService.removeStock(paramMap);
		
		return "redirect:/k1Stock";
	}
}
