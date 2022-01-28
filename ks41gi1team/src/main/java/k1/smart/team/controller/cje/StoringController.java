package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
public class StoringController {
	private final StoringService storingService;
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
	public String storingMain(Model model, HttpSession session) {
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "전체목록");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", (String) session.getAttribute("MAINBUSINESSCODE"));
		
		resultMap = storingService.getAllStoringList(paramMap);
		if(CommonUtils.isEmpty(resultMap)) return "storing/storing_history";

		//최근 물류이동 현황
		//log.info("최근 물류이동 :: {}", resultMap.get("recentStoring"));
		model.addAttribute("recentStoring", resultMap.get("recentStoring"));
		//최근 생산출하 현황
		//log.info("최근 생산출하 :: {}", resultMap.get("recentProShip"));
		model.addAttribute("recentProShip", resultMap.get("recentProShip"));
		
		//물류 전체목록
		storingList = (List<Storing>) resultMap.get("storingList");
		//log.info("물류이동내역 LIST :: {}", storingList);
		model.addAttribute("storingList", storingList);
		
		return "storing/storing_history";
	}
	
	/**
	 * 물류이동내역 삭제
	 * @param stockAdjList
	 * @param stockReason
	 */
	@PostMapping("/k1StoringRemove")
	public String removeStoringInfo(
			@RequestParam(value = "stockAdjCode") String stockAdjList, String stockReason) {
		//매개변수 확인
		if(CommonUtils.isEmpty(stockAdjList)) return "redirect:/k1"+stockReason;
		log.info("삭제할 물류이동코드 :: {}",stockAdjList);
		//map
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//삭제 프로세스
		for(String stockAdjCode : stockAdjList.split(",")) {
			paramMap.clear();
			paramMap.put("stockAdjCode", stockAdjCode);
			storingService.removeStoringInfo(paramMap);
		}
		
		return "redirect:/k1"+stockReason;
	}
}
