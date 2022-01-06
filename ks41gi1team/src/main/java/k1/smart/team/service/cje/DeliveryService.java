package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.mapper.cje.DeliveryMapper;

@Service
public class DeliveryService {
	private DeliveryMapper deliveryMapper;
	private Delivery deliveryInfo; //운송요청정보
	private List<Delivery> deliveryList; //운송요청정보 배열
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
}
