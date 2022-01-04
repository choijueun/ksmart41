package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ReturnService;

@Controller
public class ReturnController {
	private ReturnService returnService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private List<Storing> returnList; //반품처리내역 배열
	private Storing returnInfo; //반품처리내역 하나
	/**
	 * 생성자 메서드
	 * @param returnService
	 */
	public ReturnController(ReturnService returnService) {
		this.returnService = returnService;
	}
	
	//반품내역 전체목록
	@GetMapping("/k1Return")
	public String returnMain(Model model) {
		returnList = returnService.getAllReturnList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "반품처리내역");
		model.addAttribute("returnList", returnList);
		
		return "storing/return/return_list";
	}
	
	//반품내역 상세정보
	@GetMapping("/k1Return/{stockAdjCode}")
	public String returnInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/return/return_info";
	}
	
	//반품내역 신규등록
	@GetMapping("/k1ReturnAdd")
	public String addReturn(Model model) {
		return "storing/return/return_add";
	}
	
	//반품내역 수정
	@GetMapping("/k1ReturnModify/{stockAdjCode}")
	public String modifyReturn(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/return/return_modify";
	}
	
	//반품요청내역 전체목록
	@GetMapping("/k1ReturnReq")
	public String returnReqMain(Model model) {
		return "storing/return/return_request_list";
	}
	
	//반품요청내역 상세정보
	@GetMapping("/k1ReturnReq/{returnRegCode}")
	public String returnReqInfo(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		return "storing/return/return_request_info";
	}

	//반품요청내역 신규등록
	@GetMapping("/k1ReturnReqAdd")
	public String addReturnReq(Model model) {
		return "storing/return/return_request_add";
	}
	
	//반품요청내역 수정
	@GetMapping("/k1ReturnReqModify/{returnRegCode}")
	public String modifyReturnReq(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		return "storing/return/return_request_modify";
	}
}
