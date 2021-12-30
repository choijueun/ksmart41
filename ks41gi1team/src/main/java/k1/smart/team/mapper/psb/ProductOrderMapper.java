package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.ProductOrder;
@Mapper
public interface ProductOrderMapper {

	List<ProductOrder> getAllProductOrderList(String mainBusinessCode);

}
