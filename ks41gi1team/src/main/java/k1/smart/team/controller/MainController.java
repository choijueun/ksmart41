package k1.smart.team.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.service.MainService;

@Controller
public class MainController {
	//Service
	private MainService mainService;
	//로그인 및 인터셉터 기능이 구현중에 있어 임시로 지정한 사업장대표코드(여러 공장 중 하나 선택)
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
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
	public String main(Model model) {
		//미완 배송요청·출하계획·반품요청 건수 조회
		resultMap = mainService.getUnfinishedCnt(mainBusinessCode);
		if(!CommonUtils.isEmpty(resultMap)) {
			//view에 데이터 전달
			model.addAttribute("unfinishedDeliveryCnt", resultMap.get("unfinishedDeliveryCnt"));
			model.addAttribute("unfinishedShipmentCnt", resultMap.get("unfinishedShipmentCnt"));
			model.addAttribute("unfinishedReturnCnt", resultMap.get("unfinishedReturnCnt"));
		}
		
		return "main";
	}
}
