package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ProductOrder;
@Mapper
public interface ProductOrderMapper {

	//수주 등록
		public int addProductOrder(ProductOrder productOrder);
		
		public List<ProductOrder> getProductOrderList();

	
	//하나의 수주 검색
	public List<ProductOrder> getProductOrderListBySearchKey(String searchKey, String searchValue);
	
	//전체 수주 검색
	public List<ProductOrder> getAllProductOrderList(String mainBusinessCode);

	//수주 삭제
	public String k1ProductOrderRemove();

	//수주내역 상세
	public ProductOrder getProductOrderInfo(String productOrderCode);

	//수주내역 상세조회(여러개)
	public List<ProductOrder> getProductOrderInfoList(String productOrderCode);

	//등록할때마다 하나의 새로운 수주코드 추가
	public String getProductOrderCode();
	
}
