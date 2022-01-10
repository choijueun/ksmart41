package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.WarehousingService;

@Controller
public class WarehousingController {
	private WarehousingService warehousingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing warehousingInfo; //자재사용내역 하나
	private List<Storing> warehousingList; //자재사용내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param warehousingService
	 */
	public WarehousingController(WarehousingService warehousingService) {
		this.warehousingService = warehousingService;
	}

	/**
	 * 입고내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Warehousing")
	public String warehousingMain(Model model) {
		warehousingList = warehousingService.getAllWarehousingList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고");
		model.addAttribute("warehousingList", warehousingList);
		
		return "storing/warehousing/warehousing_list";
	}
	
	/**
	 * 입고내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Warehousing/{stockAdjCode}")
	public String warehousingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Warehousing";
		
		resultMap = warehousingService.getWarehousingInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Warehousing";
		
		warehousingInfo = (Storing) resultMap.get("warehousingInfo");
		warehousingList = (List<Storing>) resultMap.get("warehousingDetails");
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고 상세정보");
		model.addAttribute("s", warehousingInfo);
		model.addAttribute("details", warehousingList);
		return "storing/warehousing/warehousing_info";
	}
	
	/**
	 * 입고내역 신규등록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1WarehousingAdd")
	public String addWarehousing(Model model) {
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 등록");
		
		return "storing/warehousing/warehousing_add";
	}
	
	/**
	 * 입고내역 수정
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1WarehousingModify/{stockAdjCode}")
	public String modifyWarehousing(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/warehousing/warehousing_modify";
	}
}
