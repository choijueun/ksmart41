package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.service.pjh.SlipService;

@Controller
@RequestMapping(value="/k1SlipList")
public class SlipController {
	private SlipService slipService;
	private String mainBusinessCode;
	private Slip purchaseSlipInfo; //전표 하나 정보
	private Slip salesSlipInfo; //전표 하나 정보
	
	public SlipController(SlipService slipService) {
		this.slipService = slipService;
	}
	
	//전표 전체목록
	@GetMapping("")
	public String slipMain(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001";
		List<Slip> p_slipList = slipService.getAllPSlipList(mainBusinessCode);
		List<Slip> s_slipList = slipService.getAllSSlipList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "전표관리");
		model.addAttribute("SectionLocation", "전표조회");
		model.addAttribute("p_slipList", p_slipList);
		model.addAttribute("s_slipList", s_slipList);
		return "slip/slip_list";
	}
	
	//비용전표 상세
	@GetMapping("/purchase/{purchaseSlipCode}")
	public String purchaseSlipInfo(
			@PathVariable(value="purchaseSlipCode", required=false) String purchaseSlipCode
			,Model model) {
		
		
		if(purchaseSlipCode == null || "".equals(purchaseSlipCode)) {
			System.out.println("비용전표코드 ERROR");
			return "redirect:/k1SlipList";
		}
		
		purchaseSlipInfo = slipService.getPurchaseSlipInfo(purchaseSlipCode);
		if(purchaseSlipInfo == null) {
			System.out.println("비용전표코드 ERROR");
			return "redirect:/k1SlipList";
		}
		
		model.addAttribute("SectionTitle", "전표관리");
		model.addAttribute("SectionLocation", "비용전표상세");
		model.addAttribute("purchaseSlipInfo", purchaseSlipInfo);
		return "slip/slip_purchaseDetail";
	}
	
	//매출전표 상세
	@GetMapping("/sales/{salesSlipCode}")
	public String salesSlipInfo(
			@PathVariable(value="salesSlipCode", required=false) String salesSlipCode
			,Model model) {
		if(salesSlipCode == null || "".equals(salesSlipCode)) {
			System.out.println("매출전표코드 ERROR");
			return "redirect:/k1SlipList";
		}
		
		salesSlipInfo = slipService.getSalesSlipInfo(salesSlipCode);
		if(salesSlipInfo == null) {
			System.out.println("비용전표코드 ERROR");
			return "redirect:/k1SlipList";
		}
		
		model.addAttribute("SectionTitle", "전표관리");
		model.addAttribute("SectionLocation", "매출전표상세");
		model.addAttribute("salesSlipInfo", salesSlipInfo);
		return "slip/slip_salesDetail";
	}
	
	//전표 등록화면
	@GetMapping("/add")
	public String addSlip(Model model) {
		model.addAttribute("title", "전표관리: 등록");
		return "slip/slip_register";
	}
	
	/**
	 * 전표 등록절차 수행
	 * @param slip
	 */
	@PostMapping("/add")
	public String addSlip(Slip slip) {
		System.out.println("SlipController에서 입력받은값" + slip);
		
		System.out.println(slip.getTsCode() + "<-- 220112 slip.getTsCode() addSlip  SlipController.java 비용 거래명세서 코드 ");
		slipService.addSlip(slip);
		

		return "redirect:/k1SlipList";
		
	}
	
	//매출전표 수정시 값 세팅하면서 화면 이동
	@GetMapping("/salesModify/{salesSlipCode}")
	public String salesModifySlip(
			@PathVariable(value="salesSlipCode", required=false) String salesSlipCode
			,Model model) {
		Slip salesSlipData = slipService.getSalesSlipData(salesSlipCode);
		model.addAttribute("salesSlipData", salesSlipData);
		System.out.println("컨트롤러 수정화면 넘어갈 때 들어올값"+salesSlipData);
		
		model.addAttribute("title", "전표관리: 수정");
		model.addAttribute("salesSlipCode", salesSlipCode);
		return "slip/slip_salesModify";
	}
	
	//비용전표 수정시 값 세팅하면서 화면 이동
	@GetMapping("/purchaseModify/{purchaseSlipCode}")
	public String purchaseModifySlip(
			@PathVariable(value="purchaseSlipCode", required=false) String purchaseSlipCode
			,Model model) {
		Slip purchaseSlipData = slipService.getPurchaseSlipData(purchaseSlipCode);
		model.addAttribute("purchaseSlipData", purchaseSlipData);
		System.out.println("컨트롤러 수정화면 넘어갈 때 들어올값"+purchaseSlipData);
		
		model.addAttribute("title", "전표관리: 수정");
		model.addAttribute("purchaseSlipCode", purchaseSlipCode);
		return "slip/slip_purchaseModify";
	}
	
	//매출전표 수정절차 수행 (통합회계 반영)
	@PostMapping("/salesModify")
	public String salesSlipModify(Slip slip) {
		System.out.println("매출전표 수정"+ slip);
		slipService.salesSlipModify(slip);
		
		return "redirect:/k1SlipList";
	}
	
	//비용전표 수정절차 수행 (통합회계 반영)
	@PostMapping("/purchaseModify")
	public String purchaseSlipModify(Slip slip) {
		System.out.println("비용전표 수정"+ slip);
		slipService.purchaseSlipModify(slip);
		
		return "redirect:/k1SlipList";
	}
			
	
}	