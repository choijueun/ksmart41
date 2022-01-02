package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.StoringService;

@Controller
@RequestMapping(value="/k1Storing")
public class StoringController {
	private StoringService storingService;
	private String mainBusinessCode; //사업장대표코드
	private List<Storing> storingList; //물류 배열
	private Storing storing; //물류
	
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
	 * @return storing_history (List<Storing>)
	 */
	@GetMapping("")
	public String storingMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
		//재고 전체목록
		storingList = storingService.getAllStoringList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("storingList", storingList);
		return "storing/storing_history";
	}
}
