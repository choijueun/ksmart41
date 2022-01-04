package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.ProductOrder;
@Mapper
public interface ProductOrderMapper {

	//하나의 수주 검색
	List<ProductOrder> getProductOrderListBySearchKey(String searchKey, String searchValue);
	
	//전체 수주 검색
	List<ProductOrder> getAllProductOrderList(String mainBusinessCode);
}
