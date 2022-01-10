package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ProductionService;

@Controller
public class ProductionController {
	private ProductionService productionService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing productionInfo; //출하내역 하나
	private List<Storing> productionList; //출하내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param productionService
	 */
	public ProductionController(ProductionService productionService) {
		this.productionService = productionService;
	}
	
	@GetMapping("/k1Production")
	public String productionMain(Model model) {
		productionList = productionService.getAllProductionList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		model.addAttribute("productionList", productionList);
		
		return "storing/production/production_list";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/k1Production/{stockAdjCode}")
	public String productionInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Production";
		
		resultMap = productionService.getProductionInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Production";
		
		productionInfo = (Storing) resultMap.get("productionInfo");
		productionList = (List<Storing>) resultMap.get("productionDetails");
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "제품생산");
		model.addAttribute("s", productionInfo);
		model.addAttribute("productionDetails", productionList);
		
		return "storing/production/production_info";
	}
	
	@GetMapping("/k1ProductionAdd")
	public String addProduction(Model model) {
		return "storing/production/production_add";
	}
	
	@GetMapping("/k1ProductionModify/{stockAdjCode}")
	public String modifyProduction(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/production/production_modify";
	}
}
