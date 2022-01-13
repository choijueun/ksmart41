package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Invoice;

@Mapper
public interface InvoiceMapper {
	
	//세금계산서 전체 목록 조회
	public List<Invoice> getAllInvoiceList();

	//세금계산서 상세
	public Invoice getInvoiceDetail(String invoiceCode);
}
