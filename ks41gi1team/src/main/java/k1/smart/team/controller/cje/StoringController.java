package k1.smart.team.controller.cje;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.service.cje.StoringService;

@Controller
public class StoringController {
	private final StoringService storingService;
	private String mainBusinessCode= "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Map<String, Object> resultMap;
	
	/**
	 * 생성자 메서드
	 * @param storingService
	 */
	public StoringController(StoringService storingService) {
		this.storingService = storingService;
	}
	
	/**
	 * 물류 전체목록 조회
	 * @param model 
	 */
	@GetMapping("/k1Storing")
	public String storingMain(Model model) {
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "전체목록");
		
		resultMap = storingService.getAllStoringList(mainBusinessCode);
		if(CommonUtils.isEmpty(resultMap)) return "storing/storing_history";

		//최근 물류내역
		model.addAttribute("recentStoring", resultMap.get("recentStoring"));
		//물류 전체목록
		model.addAttribute("storingList", resultMap.get("storingList"));
		
		return "storing/storing_history";
	}
}
