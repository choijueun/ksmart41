package k1.smart.team.service.pjh;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.Is;
import k1.smart.team.mapper.pjh.IsMapper;

@Service
public class IsService {
	private IsMapper invoiceMapper;
	private List<Is> invoiceList;
	
	//생성자메서드
	public IsService(IsMapper invoiceMapper) {
		this.invoiceMapper = invoiceMapper;
	}
	
	

	public List<Is> getInvoiceList() {
		invoiceList = invoiceMapper.getInvoiceList();
		
		return invoiceList;
	}
	//매출
	public Is getTotalSales(Is is) {
		return invoiceMapper.getTotalSales(is);
	}
	//비용
	public Is getTotalPrice(Is is) {
		return invoiceMapper.getTotalPrice(is);
	}
	
	//분기별 매출
	public Is getSalesQuarter(Is is) {
		return invoiceMapper.salesQuarter(is);
	}
	//분기별 비용
	public Is getPurchaseQuarter(Is is) {
		return invoiceMapper.purchaseQuarter(is);
	}
	//분기별 기타비용
	public Is getEtcPurchaseQuarter(Is is) {
		return invoiceMapper.etcPurchaseQuarter(is);
	}

}
