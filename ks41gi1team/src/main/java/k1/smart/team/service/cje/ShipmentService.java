package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ShipmentService {
	private final StoringMapper storingMapper;
	private Storing shipmentInfo; //출하내역 하나
	private List<Storing> shipmentList; //출하내역 배열
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
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
		shipmentList = storingMapper.getAllStoringList(mainBusinessCode, "5");
		
		return shipmentList;
	}
	
	/**
	 * 출하내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String, Object> getShipmentInfo(String mainBusinessCode, String stockAdjCode) {
		shipmentInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "5");
		if(shipmentInfo == null) return null;
		shipmentList = storingMapper.getShipmentDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("shipmentInfo", shipmentInfo);
		resultMap.put("shipmentDetails", shipmentList);
		
		return resultMap;
	}
	
	/**
	 * 출하계획 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getShipmentPlanList(String mainBusinessCode) {
		shipmentList = storingMapper.getShipmentPlanList(mainBusinessCode);
		
		return shipmentList;
	}
	
	/**
	 * 출하내역 상세조회
	 * @param mainBusinessCode
	 * @param shipmentPlanCode
	 * @return
	 */
	public Map<String, Object> getShipmentPlanInfo(String mainBusinessCode, String shipmentPlanCode) {
		shipmentInfo = storingMapper.getShipmentPlanInfo(mainBusinessCode, shipmentPlanCode);
		if(shipmentInfo == null) return null;
		shipmentList = storingMapper.getShipmentPlanDetails(shipmentPlanCode);
		
		resultMap.clear();
		resultMap.put("shipPlanInfo", shipmentInfo);
		resultMap.put("shipPlanDetails", shipmentList);
		
		return resultMap;
	}
	
}
