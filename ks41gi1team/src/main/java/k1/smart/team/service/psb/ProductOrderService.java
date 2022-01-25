package k1.smart.team.service.psb;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.ProductOrderMapper;

@Service
public class ProductOrderService {
	private ProductOrderMapper productOrderMapper;
	private List<ProductOrder> productOrderList;
	private ProductOrder productOrderInfo;

	@Autowired
	private CodeMapper codeMapper;

	
	//생성자 메서드 주입
	public ProductOrderService(ProductOrderMapper productOrderMapper) {
		this.productOrderMapper = productOrderMapper;
	}
	
	//수주 등록
		public int addProductOrder(ProductOrder productOrder) {
			
			int result = productOrderMapper.addProductOrder(productOrder);
			
			return result;
		}
		
		public List<ProductOrder> getProductOrderList(){
			List<ProductOrder> productOrderList = productOrderMapper.getProductOrderList();
			
			return productOrderList;
		}
		
	//수주 등록할때마다 새로운 수주코드 생성
		public String getProductOrderCode() {
			return productOrderMapper.getProductOrderCode();
		}
	
	//하나의 수주 검색
	public List<ProductOrder> getProductOrderListBySearchKey(String searchKey, String searchValue) {
		
		return productOrderMapper.getProductOrderListBySearchKey(searchKey, searchValue);
	}

	//전체 수주 검색
	public List<ProductOrder> getAllProductOrderList(){
		productOrderList = productOrderMapper.getAllProductOrderList();
	
		String productOrderNum;
		for(int i=0; i<productOrderList.size(); i++) {
			productOrderNum = productOrderList.get(i).getProductOrderCode().replace("product_orderCode_", "");
			productOrderList.get(i).setProductOrderCode(productOrderNum);
		}
		return productOrderList;
	}
	
	//수주 삭제
	public String k1ProductOrderRemove() {
			String result = productOrderMapper.k1ProductOrderRemove();
		return result;
	}

	//수주 상세
	public ProductOrder getProductOrderInfo(String productOrderCode) {
		productOrderInfo = productOrderMapper.getProductOrderInfo("product_orderCode_"+productOrderCode);

		System.out.println("서비스 productOrderCode-->" + productOrderCode);
		System.out.println("productOrderInfo 값세팅전-->:" + productOrderInfo);
		if(productOrderInfo == null) {
			System.out.println("수주정보 조회결과 없음");
			return null;
		}

		productOrderInfo.setProductOrderCode(productOrderCode);
		System.out.println("서비스 productOrderCode-->" + productOrderCode);
		System.out.println("productOrderInfo 갑세팅후-->:" + productOrderInfo);
		return productOrderInfo;
	}

	
	

}
