package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class MovingController {
	private final StoringService storingService;
	private Map<String, Object> resultMap;
	private Stock stockInfo; //재고정보
	private Storing movingInfo; //생산내역
	private List<Storing> movingList; //창고이동내역 배열
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private static final Logger log = LoggerFactory.getLogger(MovingController.class);
	
	/**
	 * 생성자 메서드
	 * @param movingService
	 */
	public MovingController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 창고이동내역 전체조회
	 * @param model
	 */
	@GetMapping("/k1Moving")
	public String movingMain(Model model) {
		//창고이동내역 전체목록 List<Storing>
		movingList = storingService.getAllMovingList(mainBusinessCode);
		log.info("창고이동내역 LIST :: {}", movingList);
		model.addAttribute("movingList", movingList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "창고이동");
		
		return "storing/moving/moving_list";
	}
	
	/**
	 * 창고이동내역 상세조회
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1Moving/{stockAdjCode}")
	public String movingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Moving";
		
		//창고이동내역 상세정보 조회결과
		resultMap = storingService.getMovingInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Moving";
		
		//창고이동내역 한줄정보 Storing
		movingInfo = (Storing) resultMap.get("movingInfo");
		log.info("창고이동내역 INFO :: {}", movingInfo);
		model.addAttribute("s", movingInfo);
		//창고이동내역 상세정보 List<Storing>
		model.addAttribute("movingDetails", resultMap.get("movingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "창고이동");
		
		return "storing/moving/moving_info";
	}
	
	/**
	 * 창고이동내역 신규등록(+재고하나정보)
	 * @param inventoryCode
	 * @param model
	 */
	@GetMapping("/k1MovingAdd")
	public String addMoving(
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
		model.addAttribute("SectionLocation", "창고이동내역 등록");
		
		return "storing/moving/moving_add";
	}
	
	/**
	 * 창고이동내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MovingAdd")
	public String addMoving(Storing storingInfo) {
		//창고이동내역 등록 프로세스
		
		return "redirect:/k1Moving";
	}
	
	/**
	 * 창고이동내역 수정화면
	 * @param stockAdjCode
	 * @param model
	 */
	@GetMapping("/k1MovingModify/{stockAdjCode}")
	public String modifyMoving(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Moving";
		
		//창고이동내역 상세정보 조회결과
		resultMap = storingService.getMovingInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Moving";
		
		//창고이동내역 한줄정보 Storing
		movingInfo = (Storing) resultMap.get("movingInfo");
		log.info("창고이동내역 INFO :: {}", movingInfo);
		model.addAttribute("s", movingInfo);
		//창고이동내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("movingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "창고이동내역 수정");
		
		return "storing/moving/moving_modify";
	}
	
	/**
	 * 창고이동내역 수정프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MovingModify")
	public String modifyMoving(Storing storingInfo) {
		//창고이동내역 수정프로세스
		
		return "redirect:/k1Moving";
	}
	
	/**
	 * 창고이동내역 삭제 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1MovingRemove")
	public String removeMoving(Storing storingInfo) {
		//창고이동내역 삭제 프로세스
		return "redirect:/k1Moving";
	}
}

