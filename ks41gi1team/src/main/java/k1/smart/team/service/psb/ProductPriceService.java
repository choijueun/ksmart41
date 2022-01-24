package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.controller.psb.ProductPriceController;
import k1.smart.team.dto.psb.ManufacturingCost;
import k1.smart.team.dto.psb.ProductPrice;
import k1.smart.team.mapper.psb.ProductPriceMapper;

@Service
public class ProductPriceService {
	private ProductPriceMapper productPriceMapper;
	private List<ProductPrice> prodcutPriceList;
	

	
	
	public ProductPriceService(ProductPriceMapper productPriceMapper) {
		this.productPriceMapper = productPriceMapper;
	}
	
	//전체 비용 검색
	public List<ProductPrice> getProductPriceList(){
		List<ProductPrice> productPriceList= productPriceMapper.getProductPriceList();

		if(CommonUtils.isEmpty(productPriceList)) {
			
			System.out.println("productPriceList"+ productPriceList +"서비스 null이다.");
			// 널(null)이거나 공백(빈칸)일 경우 실행
			
		} else {
			System.out.println("productPriceList"+ productPriceList +"서비스 null이 아니다.");
			// 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
			
		}
		return productPriceList;
	}
	
	
}
