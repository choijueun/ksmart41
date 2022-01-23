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
public class WarehousingController {
	private final StoringService storingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Stock stockInfo; //재고정보
	private Storing warehousingInfo; //자재입고내역
	private List<Storing> warehousingList; //자재입고내역 배열
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(WarehousingController.class);
	/**
	 * 생성자 메서드
	 * @param warehousingService
	 */
	public WarehousingController(StoringService storingService) {
		this.storingService = storingService;
	}

	/**
	 * 입고내역 전체목록
	 * @param model
	 */
	@GetMapping("/k1Warehousing")
	public String warehousingMain(Model model) {
		//입고내역 전체목록 List<Storing>
		warehousingList = storingService.getAllWarehousingList(mainBusinessCode);
		//log.info("자재입고내역 LIST :: {}", warehousingList);
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
		resultMap = storingService.getWarehousingInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		
		//자재입고내역 한줄정보 Storing
		warehousingInfo = (Storing) resultMap.get("warehousingInfo");
		//log.info("자재입고내역 상세정보 INFO :: {}", warehousingInfo);
		model.addAttribute("s", warehousingInfo);
		//자재입고내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("warehousingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고");
		
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
			//해당 재고 정보
			stockInfo = storingService.getStockForStoring(mainBusinessCode, inventoryCode);
			//log.info("특정재고정보 INFO :: {}", stockInfo);
			model.addAttribute("s", stockInfo);
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 등록");
		
		return "storing/warehousing/warehousing_add";
	}
	
	/**
	 * 입고내역 등록 프로세스
	 * @param storingInfo
	 */
	@PostMapping("/k1WarehousingAdd")
	public String addWarehousing(Storing storingInfo) {
		//상세정보(품목) 존재하지 않을 경우
		if(CommonUtils.isEmpty(storingInfo.getS())) return "redirect:/k1WarehousingAdd";
		
		//사업장코드Setting
		storingInfo.setMainBusinessCode(mainBusinessCode);
		//물류이동사유Setting
		storingInfo.setStockReasonCode(1);
		//log.info("물류이동한줄내역 :: {}",storingInfo);
		
		//품목정보의 각 key & value 출력
		/*
		for(Stock itemInfo : storingInfo.getS()) {
		    try{
		    	System.out.println("========= 품목정보 =========");
		        for (Field field : itemInfo.getClass().getDeclaredFields()){
		            field.setAccessible(true);
		            Object value=field.get(itemInfo);
		            System.out.println(field.getName()+": "+value);
		        }
		    }catch (Exception e){
		        e.printStackTrace();
		    }
		}
		 */
		
		//등록 process
		if(storingService.addStoringInfo(storingInfo)) {
			return "redirect:/k1Warehousing";
		}else {
			return "redirect:/k1WarehousingAdd";
		}
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
		resultMap = storingService.getWarehousingInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehousing";
		
		//자재입고내역 한줄정보 Storing
		warehousingInfo = (Storing) resultMap.get("warehousingInfo");
		log.info("자재입고내역 수정화면 INFO :: {}", warehousingInfo);
		model.addAttribute("s", warehousingInfo);
		//자재입고내역 상세정보 List<Storing>
		model.addAttribute("details", resultMap.get("warehousingDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "자재입고내역 수정");
		
		return "storing/warehousing/warehousing_modify";
	}
}
