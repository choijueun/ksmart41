package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.ProductPrice;

@Mapper
public interface ProductPriceMapper {

	public List<ProductPrice> getProductPriceList();

	public int modifyProductPrice(ProductPrice productPrice);
}
