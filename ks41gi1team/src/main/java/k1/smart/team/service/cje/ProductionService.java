package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ProductionService {
	private StoringMapper storingMapper;
	private Storing storingInfo; //출하내역 하나
	private List<Storing> storingList; //출하내역 배열
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public ProductionService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 제품생산내역 전체목록 조회
	 * @param mainBusinessCode
	 */
	public List<Storing> getAllProductionList(String mainBusinessCode) {
		return storingMapper.getAllStoringList(mainBusinessCode, "3");
	}
	
	/**
	 * 제품생산내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 */
	public Map<String, Object> getProductionInfo(String mainBusinessCode, String stockAdjCode) {
		//제품생산내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "3");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//제품생산내역 상세정보 배열
		storingList = storingMapper.getProductionDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("productionInfo", storingInfo);
		resultMap.put("productionDetails", storingList);
		
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
