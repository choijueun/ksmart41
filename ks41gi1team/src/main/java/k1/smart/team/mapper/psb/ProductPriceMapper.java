package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.ProductPrice;

@Mapper
public interface ProductPriceMapper {

	//전체 조회
	public List<ProductPrice> getProductPriceList();

	//수정
	public int modifyProductPrice(ProductPrice productPrice);

	//제품단가코드 하나 가져오기
	public String getProductPriceCode();

	public int getProductPriceByProductPriceCode(String productPriceCode);

	//상세
	public ProductPrice getProductPriceInfo(String productPriceCode);

	//등록
	public int addProductPrice(ProductPrice productPrice);
}
