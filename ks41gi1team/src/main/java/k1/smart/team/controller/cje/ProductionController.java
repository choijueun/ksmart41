package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ProductionService;

@Controller
public class ProductionController {
	private ProductionService productionService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private List<Storing> productionList; //출하내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param productionService
	 */
	public ProductionController(ProductionService productionService) {
		this.productionService = productionService;
	}
	
	/**
	 * 제품생산내역 전체목록조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Production")
	public String productionMain(Model model) {
		productionList = productionService.getAllProductionList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		model.addAttribute("productionList", productionList);
		
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
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		resultMap = productionService.getProductionInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		model.addAttribute("s", resultMap.get("productionInfo"));
		model.addAttribute("details", resultMap.get("productionDetails"));
		
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
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산내역 등록");
		
		if(CommonUtils.isEmpty(inventoryCode)) return "storing/production/production_add";
		
		model.addAttribute("s", productionService.getStockForStoring(mainBusinessCode, inventoryCode));
		
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
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Production";
		
		resultMap = productionService.getProductionInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Production";
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산내역 수정");
		model.addAttribute("s", resultMap.get("productionInfo"));
		model.addAttribute("details", resultMap.get("productionDetails"));
		
		return "storing/production/production_modify";
	}
}
