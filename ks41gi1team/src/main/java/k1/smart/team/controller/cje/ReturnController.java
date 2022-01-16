package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.ReturnService;

@Controller
public class ReturnController {
	private final ReturnService returnService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private List<Storing> returnList; //반품처리내역 배열
	private Storing returnInfo; //반품처리내역 하나
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param returnService
	 */
	public ReturnController(ReturnService returnService) {
		this.returnService = returnService;
	}
	
	/**
	 * 반품내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Return")
	public String returnMain(Model model) {
		//반품내역 전체목록 List<Storing>
		returnList = returnService.getAllReturnList(mainBusinessCode);
		model.addAttribute("returnList", returnList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리");
		
		return "storing/return/return_list";
	}
	
	/**
	 * 반품내역 상세정보
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Return/{stockAdjCode}")
	public String returnInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Return";
		
		//반품내역 상세정보 조회결과
		resultMap = returnService.getReturnInfo(mainBusinessCode, stockAdjCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Return";
		
		//반품내역 한줄정보 Storing
		model.addAttribute("s", resultMap.get("returnInfo"));
		//반품내역 상세정보 List<Storing>
		model.addAttribute("returnDetails", resultMap.get("returnDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리");
		
		return "storing/return/return_info";
	}
	
	/**
	 * 반품내역 신규등록
	 * @param inventoryCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnAdd")
	public String addReturn(
			@RequestParam(value="inventoryCode", required = false) String inventoryCode
			,Model model) {
		//inventoryCode 정보를 받은 경우
		if(!CommonUtils.isEmpty(inventoryCode)) {
			//해당 재고 정보를 model 속성에 추가
			model.addAttribute("s", returnService.getStockForStoring(mainBusinessCode, inventoryCode));
		}
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리내역 등록");
		
		return "storing/return/return_add";
	}
	
	/**
	 * 반품내역 수정화면 첫페이지
	 * @param stockAdjCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnModify/{stockAdjCode}")
	public String modifyReturn(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(stockAdjCode)) return "redirect:/k1Return";
		
		model.addAttribute("stockAdjCode", stockAdjCode);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품처리내역 수정");
		
		return "storing/return/return_modify";
	}
	
	/**
	 * 반품요청내역 전체목록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnReg")
	public String returnReqMain(Model model) {
		//반품요청내역 전체목록 List<Storing>
		returnList = returnService.getReturnRegList(mainBusinessCode);
		model.addAttribute("returnRegList", returnList);
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품요청");
		
		return "storing/return/return_request_list";
	}
	
	/**
	 * 반품요청내역 상세정보
	 * @param returnRegCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnReg/{returnRegCode}")
	public String returnReqInfo(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(returnRegCode)) return "redirect:/k1ReturnReg";
		//재고조정내역 상세정보 조회결과
		resultMap = returnService.getReturnRegInfo(returnRegCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1ReturnReg";

		//재고조정내역 한줄정보 Storing
		model.addAttribute("r", resultMap.get("returnRegInfo"));
		//재고조정내역 상세정보 List<Storing>
		model.addAttribute("returnRegDetails", resultMap.get("returnRegDetails"));
		
		model.addAttribute("SectionTitle", "물류 관리");
		model.addAttribute("SectionLocation", "반품요청정보");
		
		return "storing/return/return_request_info";
	}

	/**
	 * 반품요청내역 신규등록
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnRegAdd")
	public String addReturnReq(Model model) {
		
		return "storing/return/return_request_add";
	}
	
	/**
	 * 반품요청내역 수정
	 * @param returnRegCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ReturnRegModify/{returnRegCode}")
	public String modifyReturnReq(
			@PathVariable(value="returnRegCode", required=false) String returnRegCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(returnRegCode)) return "redirect:/k1ReturnReg";

		return "storing/return/return_request_modify";
	}
}
