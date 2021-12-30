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
		System.out.println(invoiceList);
		
		return invoiceList;
	}

}
