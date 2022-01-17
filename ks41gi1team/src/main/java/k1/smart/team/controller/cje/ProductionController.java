package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class ProductionController {
	private final StoringService storingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Stock stockInfo; //재고정보
	private Storing productionInfo; //생산내역
	private List<Storing> productionList; //생산내역 배열
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(ProductionController.class);
	
	/**
	 * 생성자 메서드
	 * @param productionService
	 */
	public ProductionController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 제품생산내역 전체목록조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Production")
	public String productionMain(Model model) {
		//제품생산내역 전체목록 List<Storing>
		productionList = storingService.getAllProductionList(mainBusinessCode);
		log.info("제품생산내역 LIST :: {}", productionList);
		model.addAttribute("productionList", productionList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		
		return "storing/production/production_list";
	}

	/**
	 * 제품생산내역 상세정보 조회
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Production/{stockAdjCode}")
	public String productionInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		//제품생산내역 상세정보 조회결과
		resultMap = storingService.getProductionInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		//제품생산내역 한줄정보 Storing
		productionInfo = (Storing) resultMap.get("productionInfo");
		log.info("제품생산내역 INFO :: {}", productionInfo);
		model.addAttribute("s", productionInfo);
		//제품생산내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("productionDetails"));

		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		
		return "storing/production/production_info";
	}
	
	/**
	 * 제품생산내역 신규등록(+재고하나정보)
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ProductionAdd")
	public String addProduction(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring(mainBusinessCode, inventoryCode);
			log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산내역 등록");
		
		return "storing/production/production_add";
	}
	
	/**
	 * 제품생산내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ProductionModify/{stockAdjCode}")
	public String modifyProduction(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		//제품생산내역 상세정보 조회결과
		resultMap = storingService.getProductionInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		//제품생산내역 한줄정보 Storing
		productionInfo = (Storing) resultMap.get("productionInfo");
		log.info("자재사용내역 INFO :: {}", productionInfo);
		model.addAttribute("s", productionInfo);
		//제품생산내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("productionDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산내역 수정");
		
		return "storing/production/production_modify";
	}
}
