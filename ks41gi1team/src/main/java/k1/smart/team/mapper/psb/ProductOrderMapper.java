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

}
