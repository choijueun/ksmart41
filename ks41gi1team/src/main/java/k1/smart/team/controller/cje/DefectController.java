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
public class DefectController {
	private final StoringService storingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Map<String, Object> resultMap;
	private Stock stockInfo; //재고정보
	private Storing defectInfo; //출하내역
	private List<Storing> defectList; //불량처리내역 배열
	private static final Logger log = LoggerFactory.getLogger(DefectController.class);
	
	/**
	 * 생성자 메서드
	 * @param defectService
	 */
	public DefectController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 불량처리내역 전체조회
	 * @param model
	 */
	@GetMapping("/k1Defect")
	public String defectMain(Model model) {
		//불량처리내역 전체목록 List<Storing> 반환 및 model 속성 추가
		defectList = storingService.getAllDefectList(mainBusinessCode);
		log.info("불량처리내역 LIST :: {}", defectList);
		model.addAttribute("defectList", defectList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "불량처리");
		
		return "storing/defect/defect_list";
	}
	
	/**
	 * 불량처리내역 상세정보 조회
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Defect/{stockAdjCode}")
	public String defectInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Defect";
		
		//불량처리내역 상세정보 조회결과
		resultMap = storingService.getDefectInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Defect";
		
		//불량처리내역 한줄정보 Storing
		defectInfo = (Storing) resultMap.get("defectInfo");
		log.info("불량처리내역 INFO :: {}", defectInfo);
		model.addAttribute("s", defectInfo);
		//불량처리내역 상세정보 List<Storing>
		model.addAttribute("defectDetail", resultMap.get("defectDetail"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "불량처리");
		
		return "storing/defect/defect_info";
	}
	
	/**
	 * 불량처리내역 신규등록(+재고정보하나)
	 * @param inventoryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1DefectAdd")
	public String addDefect(
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
		model.addAttribute("SectionLocation", "불량처리내역 등록");
		
		return "storing/defect/defect_add";
	}
	
	/**
	 * 불량처리내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1DefectModify/{stockAdjCode}")
	public String modifyDefect(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Defect";
		
		//불량처리내역 상세정보 조회결과
		resultMap = storingService.getDefectInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Defect";
		
		//불량처리내역 한줄정보 Storing
		defectInfo = (Storing) resultMap.get("defectInfo");
		log.info("자재입고내역 수정화면 INFO :: {}", defectInfo);
		model.addAttribute("s", defectInfo);
		//불량처리내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("defectDetail"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "불량처리내역 수정");
		
		return "storing/defect/defect_modify";
	}

}
