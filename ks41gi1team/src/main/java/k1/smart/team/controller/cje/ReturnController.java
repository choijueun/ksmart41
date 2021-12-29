package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.ReturnService;

@Controller
@RequestMapping(value="/k1Return")
public class ReturnController {
	private ReturnService returnService;
	public ReturnController(ReturnService returnService) {
		this.returnService = returnService;
	}
	
	//반품내역 전체목록
	@GetMapping("")
	public String returnMain(Model model) {
		return "storing/return/return_list";
	}
	
	//반품내역 상세정보
	@GetMapping("/{stockAdjCode}")
	public String returnInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/return/return_info";
	}
	
	//반품내역 신규등록
	@GetMapping("/add")
	public String addReturn(Model model) {
		return "storing/return/return_add";
	}
	
	//반품내역 수정
	@GetMapping("/modify/{stockAdjCode}")
	public String modifyReturn(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/return/return_modify";
	}
	
	//반품요청내역 전체목록
	@GetMapping("/req")
	public String returnReqMain(Model model) {
		return "storing/return/return_request_list";
	}
	
	//반품요청내역 상세정보
	@GetMapping("/req/{returnRegCode}")
	public String returnReqInfo(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		return "storing/return/return_request_info";
	}

	//반품요청내역 신규등록
	@GetMapping("/addReq")
	public String addReturnReq(Model model) {
		return "storing/return/return_request_add";
	}
	
	//반품요청내역 수정
	@GetMapping("/modifyReq/{returnRegCode}")
	public String modifyReturnReq(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		return "storing/return/return_request_modify";
	}
}
