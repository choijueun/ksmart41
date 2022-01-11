package k1.smart.team.controller.pjh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/add")
	public String addSlip(Model model) {
		model.addAttribute("title", "전표관리: 등록");
		return "slip/slip_register";
	}
	
	@PostMapping("/add")
	public String addSlip(Slip slip) {
		System.out.println("SlipController에서 입력받은값" + slip);
		slipService.addSlip(slip);
		return "redirect:/slip/slip_list";
		
	}
	
	@GetMapping("/modify/{slipCode}")
	public String modifySlip(
			@PathVariable(value="slipCode", required=false) String slipCode
			,Model model) {
		model.addAttribute("title", "전표관리: 수정");
		model.addAttribute("slipCode", slipCode);
		return "slip/slip_modify";
	}
			
	@PostMapping(value="/salesList")
	@ResponseBody
	public List<Map<String, Object>> saleTransactionList(){
		List<Map<String, Object>> salesList = slipService.saleTransactionList();
		
		return salesList;
	}
	
}	