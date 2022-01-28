package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class StoringController {
	private final StoringService storingService;
	private String mainBusinessCode= "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Map<String, Object> resultMap;
	private List<Storing> storingList; //물류이동내역 배열
	private static final Logger log = LoggerFactory.getLogger(StoringController.class);
	
	/**
	 * 생성자 메서드
	 * @param storingService
	 */
	public StoringController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 물류이동내역 전체목록 조회
	 * @param model 
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Storing")
	public String storingMain(Model model) {
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "전체목록");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		
		resultMap = storingService.getAllStoringList(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "storing/storing_history";

		//최근 물류이동 현황
		log.info("최근 물류이동 :: {}", resultMap.get("recentStoring"));
		model.addAttribute("recentStoring", resultMap.get("recentStoring"));
		//최근 생산출하 현황
		log.info("최근 생산출하 :: {}", resultMap.get("recentProShip"));
		model.addAttribute("recentProShip", resultMap.get("recentProShip"));
		
		//물류 전체목록
		storingList = (List<Storing>) resultMap.get("storingList");
		log.info("물류이동내역 LIST :: {}", storingList);
		model.addAttribute("storingList", storingList);
		
		return "storing/storing_history";
	}
}
