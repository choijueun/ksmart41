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
public class ShipmentService {
	private final StoringMapper storingMapper;
	private Storing storingInfo; //출하내역 하나
	private List<Storing> storingList; //출하내역 배열
	
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public ShipmentService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 출하내역 전체목록 조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getAllShipmentList(String mainBusinessCode) {
		return storingMapper.getAllStoringList(mainBusinessCode, "5");
	}
	
	/**
	 * 출하내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String, Object> getShipmentInfo(String mainBusinessCode, String stockAdjCode) {
		//출하내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "5");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//출하내역 상세정보 배열
		storingList = storingMapper.getShipmentDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("shipmentInfo", storingInfo);
		resultMap.put("shipmentDetails", storingList);
		
		return resultMap;
	}
	
	/**
	 * 출하계획 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getShipmentPlanList(String mainBusinessCode) {
		return storingMapper.getShipmentPlanList(mainBusinessCode);
	}
	
	/**
	 * 출하계획 상세조회
	 * @param mainBusinessCode
	 * @param shipmentPlanCode
	 * @return
	 */
	public Map<String, Object> getShipmentPlanInfo(String mainBusinessCode, String shipmentPlanCode) {
		//출하계획 정보
		storingInfo = storingMapper.getShipmentPlanInfo(mainBusinessCode, shipmentPlanCode);
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//출하계획 상세정보 배열
		storingList = storingMapper.getShipmentPlanDetails(shipmentPlanCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("shipPlanInfo", storingInfo);
		resultMap.put("shipPlanDetails", storingList);
		
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
