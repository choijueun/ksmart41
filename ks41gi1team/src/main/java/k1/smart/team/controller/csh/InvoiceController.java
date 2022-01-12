package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.Invoice;
import k1.smart.team.service.csh.InvoiceService;

@Controller
@RequestMapping(value = "/k1Invoice")
public class InvoiceController {
	private InvoiceService invoiceService;
	
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
	
	
	//매출전자세금계산서 리스트
	@GetMapping("/salesIvList")
	public String getSalesIvList(Model model) {
		
		return "invoice/sales_iv_list";
	}
	
	//매출전자세금계산서 등록
	@GetMapping("/salesIvRegister")
	public String getSalesIvRegister(Model model) {
		
		return "invoice/sales_iv_register";
	}


}
