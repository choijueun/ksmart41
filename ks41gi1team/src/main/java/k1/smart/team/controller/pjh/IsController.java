package k1.smart.team.controller.pjh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.pjh.Is;
import k1.smart.team.service.pjh.IsService;

@Controller
@RequestMapping(value = "/k1InvoiceList")
public class IsController {
	private IsService invoiceService;
	
	public IsController(IsService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	//계정과목 전체 목록
	@GetMapping("")
	public String InvoiceMain(Model model) {
		List<Is> invoiceList = invoiceService.getInvoiceList();
		
		System.out.println(invoiceList);
		model.addAttribute("title", "계정과목 조회");
		model.addAttribute("invoiceList", invoiceList);
		
		return "invoice/invoice_list";
	}
	
	
}
