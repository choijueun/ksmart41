package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.Invoice;
import k1.smart.team.service.csh.InvoiceService;

@Controller
@RequestMapping(value = "/k1Invoice")
public class InvoiceController {
	private InvoiceService invoiceService;
	private Invoice invoiceDetail; //세금계산서 상세
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	//전자세금계산서 리스트
	@GetMapping("/invoiceList")
	public String getInvoiceList(Model model) {
		
		List<Invoice> invoiceList = invoiceService.getAllPurchaseIvList();
		
		model.addAttribute("SectionTitle", "전자세금계산서 조회");
		model.addAttribute("invoiceList", invoiceList);
		
		return "invoice/invoice_list";
	}
	
	//전자세금계산서 상세
	@GetMapping("/invoiceDetail/{invoiceCode}")
	public String getInvoiceDetail(
			@PathVariable(value = "invoiceCode", required = false) String invoiceCode
			,Model model) {
		System.out.println(invoiceCode);
		//세금계산서 코드 검사
		if(invoiceCode == null || "".equals(invoiceCode)) {
			System.out.println("세금계산서코드 error");
			return "redirect:/invoiceList";
		}
		//세금계산서 상세
		invoiceDetail = invoiceService.getInvoiceDetail(invoiceCode);
		if(invoiceDetail == null) {
			System.out.println("세금계산서 상세 error");
			return "redirect:/invoiceList";
		}
		model.addAttribute("SectionTitle", "전자세금계산서 상세");
		model.addAttribute("invoiceDetail", invoiceDetail);

		return "invoice/sales_iv_detail";
	}
	
	//세금계산서 수정
	@GetMapping("/modify/{invoiceCode}")
	public String modifyInvoice(
			@PathVariable(value = "invoiceCode", required = false) String invoiceCode
			,Model model) {
		model.addAttribute("SectionTitle", "전자세금계산서: 수정");
		model.addAttribute("invoiceCode", invoiceCode);
		return "invoice/sales_iv_modify";
	}
	
	
	//매출전자세금계산서 등록
	@GetMapping("/salesIvRegister")
	public String getSalesIvRegister(Model model) {
		model.addAttribute("SectionTitle", "전자세금계산서 등록");
		return "invoice/sales_iv_register";
	}


}
