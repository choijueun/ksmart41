package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ProductionService {
	private StoringMapper storingMapper;
	private Storing productionInfo; //출하내역 하나
	private List<Storing> productionList; //출하내역 배열
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public ProductionService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	public List<Storing> getAllProductionList(String mainBusinessCode) {
		productionList = storingMapper.getAllStoringList(mainBusinessCode, "3");
		
		return productionList;
	}
	
	public Map<String, Object> getProductionInfo(String mainBusinessCode, String stockAdjCode) {
		productionInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "3");
		if(productionInfo == null) return null;
		productionList = storingMapper.getProductionDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("productionInfo", productionInfo);
		resultMap.put("productionDetails", productionList);
		
		return resultMap;
	}
	
	/**
	 * 재고정보 하나 조회
	 * @param mainBusinessCode
	 * @param inventoryCode
	 * @return
	 */
	public Stock getStockForStoring(String mainBusinessCode, String inventoryCode) {
		return storingMapper.getStockForStoring(mainBusinessCode, inventoryCode);
	}
}
