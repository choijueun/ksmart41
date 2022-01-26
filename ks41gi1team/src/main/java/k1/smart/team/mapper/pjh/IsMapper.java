package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.Is;

@Mapper
public interface IsMapper {
	//계정과목 전체조회
	public List<Is> getInvoiceList();
	//매출
	public Is getTotalSales(Is is);
	//비용
	public Is getTotalPrice(Is is);
}
