package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.mapper.psb.ProductOrderMapper;

@Service
public class ProductOrderService {
	private ProductOrderMapper productOrderMapper;
	private List<ProductOrder> productOrderList;
	
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


}
