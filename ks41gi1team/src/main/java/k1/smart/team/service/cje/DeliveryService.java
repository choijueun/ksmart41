package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.mapper.cje.DeliveryMapper;

@Service
public class DeliveryService {
	private DeliveryMapper deliveryMapper;
	private Delivery deliveryInfo; //운송요청정보
	private List<Delivery> deliveryList; //운송요청정보 배열
	private Map<String,Object> resultMap = new HashMap<String,Object>();
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
	
	public Map<String,Object> getDeliveryInfo(String mainBusinessCode, String deliveryCode) {
		deliveryInfo = deliveryMapper.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(deliveryInfo == null) return null;
		
		resultMap.clear();
		resultMap.put("deliveryInfo", deliveryInfo);
		
		
		//출하예정내역반환
		//반품요청내역반환
		
		return resultMap;
	}
}
