package k1.smart.team.service.csh;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.Invoice;
import k1.smart.team.mapper.csh.InvoiceMapper;


@Service
@Transactional
public class InvoiceService {
	private InvoiceMapper invoiceMapper;
	private List<Invoice> invoiceList;
	private Invoice invoiceDetail; //세금계산서 상세
	
	//생성자 메서드
	public InvoiceService(InvoiceMapper invoiceMapper) {
		this.invoiceMapper = invoiceMapper;
	};

	/**
	 * 
	 * 
	 */
	
	//비용전자세금계산서 전체 목록 조회
	public List<Invoice> getAllPurchaseIvList() {
		invoiceList = invoiceMapper.getAllInvoiceList();
		
		System.out.println(invoiceList);
		return invoiceList;
	}

	//세금계산서 상세
	public Invoice getInvoiceDetail(String invoiceCode) {
		invoiceDetail = invoiceMapper.getInvoiceDetail(invoiceCode);
		if(invoiceDetail == null) {
			System.out.println("조회결과 없음");
			return null;
		}
		invoiceDetail.setInvoiceCode(invoiceCode);
		return invoiceDetail;
	};
	
	//세금계산서 수정

	

}
