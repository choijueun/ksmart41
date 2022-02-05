package k1.smart.team.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.service.MainService;

@Controller
public class MainController {
	//Service
	private MainService mainService;
	//전역변수 선언
	Map<String, Object> resultMap;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	/**
	 * 프로젝트 소개 화면
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * 로그인 이후 메인화면
	 * @return
	 */
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		//미완 배송요청·출하계획·반품요청 건수 조회
		resultMap = mainService.getUnfinishedCnt((String) session.getAttribute("MAINBUSINESSCODE"));
		if(!CommonUtils.isEmpty(resultMap)) {
			//view에 데이터 전달
			model.addAttribute("deliveryCnt", resultMap.get("deliveryCnt"));
			model.addAttribute("shipmentPlanCnt", resultMap.get("shipmentPlanCnt"));
			model.addAttribute("returnRegCnt", resultMap.get("returnRegCnt"));
		}
		return "main";
	}
}
