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
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.WarehousingService;

@Controller
public class WarehousingController {
	private final WarehousingService warehousingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing warehousingInfo; //자재사용내역 하나
	private List<Storing> warehousingList; //자재사용내역 배열
	private Map<String, Object> resultMap;
	
	private static final Logger log = LoggerFactory.getLogger(WarehousingController.class);
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
	 */
	@GetMapping("/k1Warehousing")
	public String warehousingMain(Model model) {
		//입고내역 전체목록 List<Storing>
		warehousingList = warehousingService.getAllWarehousingList(mainBusinessCode);
		model.addAttribute("warehousingList", warehousingList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고");
		
		return "storing/warehousing/warehousing_list";
	}
	
	/**
	 * 입고내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Warehousing/{stockAdjCode}")
	public String warehousingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Warehousing";
		
		//자재입고내역 상세정보 조회결과
		resultMap = warehousingService.getWarehousingInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//자재입고내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("warehousingInfo"));
		//자재입고내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("warehousingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고 상세정보");
		
		return "storing/warehousing/warehousing_info";
	}
	
	/**
	 * 입고내역 신규등록화면 (+특정재고)
	 * @param model
	 */
	@GetMapping("/k1WarehousingAdd")
	public String addWarehousing(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보를 model 속성에 추가
			model.addAttribute("s", warehousingService.getStockForStoring(mainBusinessCode, inventoryCode));
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 등록");
		
		return "storing/warehousing/warehousing_add";
	}
	
	/**
	 * 입고내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1WarehousingModify/{stockAdjCode}")
	public String modifyWarehousing(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Warehousing";
		
		//자재입고내역 상세정보 조회결과
		resultMap = warehousingService.getWarehousingInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//자재입고내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("warehousingInfo"));
		//자재입고내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("warehousingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 수정");
		
		return "storing/warehousing/warehousing_modify";
	}
}
