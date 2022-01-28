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
	private Is totalPrice;
	private Is totalSales;
	private Is salesQuarter;
	private Is purchaseQuarter;
	private Is etcPurchaseQuarter;
	
	
	public IsController(IsService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	//통합회계 결산.
	@GetMapping("")
	public String InvoiceMain(Model model) {
		List<Is> invoiceList = invoiceService.getInvoiceList();
		Is getTotalSales = invoiceService.getTotalSales(totalSales);
		Is getTotalPrice = invoiceService.getTotalPrice(totalPrice);
		Is getSalesQuarter = invoiceService.getSalesQuarter(salesQuarter);
		Is getPurchaseQuarter = invoiceService.getPurchaseQuarter(purchaseQuarter);
		Is getEtcPurchaseQuarter = invoiceService.getEtcPurchaseQuarter(etcPurchaseQuarter);
		
		model.addAttribute("getTotalSales", getTotalSales);
		model.addAttribute("getTotalPrice", getTotalPrice);
		model.addAttribute("getSalesQuarter", getSalesQuarter);
		model.addAttribute("getPurchaseQuarter", getPurchaseQuarter);
		model.addAttribute("getEtcPurchaseQuarter", getEtcPurchaseQuarter);
		
		model.addAttribute("SectionLocation", "결산");
		model.addAttribute("SectionTitle", "재무관리");
		model.addAttribute("title", "계정과목 조회");
		model.addAttribute("invoiceList", invoiceList);
		
		return "totalAc/Is";
	}
	
}
