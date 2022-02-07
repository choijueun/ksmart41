package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.controller.psb.ProductPriceController;
import k1.smart.team.dto.psb.ManufacturingCost;
import k1.smart.team.dto.psb.ProductPrice;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.ProductPriceMapper;

@Service
public class ProductPriceService {
	private ProductPriceMapper productPriceMapper;
	private List<ProductPrice> prodcutPriceList;
	

	@Autowired
	private CodeMapper codeMapper;
	private ProductPrice productPriceInfo;
	
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

	//단가 수정
	public int modifyProductPrice(ProductPrice productPrice) {
		
		return productPriceMapper.modifyProductPrice(productPrice);
	}
	
	//단가 등록할때마다 새로운 제품단가코드 생성
	public String getProductPriceCode() {
		return productPriceMapper.getProductPriceCode();
	}

	//제품단가 여부 체크
	public int getProductPriceByProductPriceCode(String productPriceCode) {
		int result = 0;
		result += productPriceMapper.getProductPriceByProductPriceCode(productPriceCode);
		return result;
	}

	//제품단가 상세
	public ProductPrice getProductPriceInfo(String productPriceCode) {
		productPriceInfo = productPriceMapper.getProductPriceInfo("productPriceCode_"+productPriceCode);
				
		if(productPriceInfo == null) {
			System.out.println("제품단가 조회결과 없음");
			return null;
		}
		
		productPriceInfo.setProductPriceCode(productPriceCode);
		
		
		return productPriceInfo;
	}

	//제품단가 등록
	public int addProductPrice(ProductPrice productPrice) {
			
			int result = productPriceMapper.addProductPrice(productPrice);
			return result;
	}


	
	
}
