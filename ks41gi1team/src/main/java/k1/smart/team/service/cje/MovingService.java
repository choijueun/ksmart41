package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class MovingService {
	private StoringMapper storingMapper;
	private Storing movingInfo; //창고이동내역 하나
	private List<Storing> movingList; //창고이동내역 배열
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public MovingService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 창고이동내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getAllShipmentList(String mainBusinessCode) {
		movingList = storingMapper.getAllStoringList(mainBusinessCode, "4");
		
		return movingList;
	}
	
	/**
	 * 창고이동내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String,Object> getMovingInfo(String mainBusinessCode, String stockAdjCode) {
		movingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "4");
		if(movingInfo == null) return null;
		movingList = storingMapper.getMovingDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("movingInfo", movingInfo);
		resultMap.put("movingDetails", movingList);
		
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
