package k1.smart.team.service.psb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.mapper.psb.ProductOrderMapper;

@Service
public class ProductOrderService {
	private ProductOrderMapper productOrderMapper;
	private List<ProductOrder> productOrderList;
	private ProductOrder productOrderInfo;
	private List<ProductOrder> productOrderInfoList;
	private Map<String,Object> resultMap = new HashMap<String,Object>();

	
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
	
	//하나의 수주 검색
	public List<ProductOrder> getProductOrderListBySearchKey(String searchKey, String searchValue) {
		
		return productOrderMapper.getProductOrderListBySearchKey(searchKey, searchValue);
	}

	//전체 수주 검색
	public List<ProductOrder> getAllProductOrderList(String mainBusinessCode){
		productOrderList = productOrderMapper.getAllProductOrderList(mainBusinessCode);
	
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
		productOrderInfo = productOrderMapper.getProductOrderInfo(productOrderCode);

		if(productOrderInfo == null) {
			System.out.println("발주정보 조회결과 없음");
			return null;
		}

		productOrderInfo.setProductOrderCode(productOrderCode);
		System.out.println("productOrderInfo-->:" + productOrderInfo);
		return productOrderInfo;
	}


}
