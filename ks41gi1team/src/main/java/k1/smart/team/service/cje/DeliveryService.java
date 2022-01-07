package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.DeliveryMapper;

@Service
public class DeliveryService {
	private DeliveryMapper deliveryMapper;
	private Delivery deliveryInfo; //운송요청정보
	private List<Delivery> deliveryList; //운송요청정보 배열
	private List<Storing> storingList; //물류이동정보 배열
	private Map<String,Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param deliveryMapper
	 */
	public DeliveryService(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}
	
	/**
	 * 운송요청내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Delivery> getAllDeliveryList(String mainBusinessCode) {
		deliveryList = deliveryMapper.getAllDeliveryList(mainBusinessCode);
		return deliveryList;
	}
	
	/**
	 * 운송요청내역 상세조회
	 * @param mainBusinessCode
	 * @param deliveryCode
	 * @return
	 */
	public Map<String,Object> getDeliveryInfo(String mainBusinessCode, String deliveryCode) {
		//운송요청
		deliveryInfo = deliveryMapper.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(deliveryInfo == null) return null;
		resultMap = new HashMap<String, Object>();
		resultMap.put("deliveryInfo", deliveryInfo);
		
		//물류이동 사유
		int stockReasonCode;
		stockReasonCode = deliveryInfo.getStockReasonCode();
		if(stockReasonCode == 5) {
			//출하계획
			deliveryInfo.setStockReasonEng("Shipment");
			storingList = deliveryMapper.getShipPlanDetails(deliveryInfo.getShipmentPlanCode());
			resultMap.put("shipPlanDetails", storingList);
		} else if(stockReasonCode == 7) {
			//반품요청
			deliveryInfo.setStockReasonEng("Return");
			storingList = deliveryMapper.getReturnRegDetails(deliveryInfo.getReturnRegCode());
			resultMap.put("returnRegDetails", storingList);
		}
		
		return resultMap;
	}
}
