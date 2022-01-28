package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.mapper.cje.DeliveryMapper;

@Service
@Transactional
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
	 * 운송요청내역 전체목록 조회
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
		//운송요청내역 정보
		deliveryInfo = deliveryMapper.getDeliveryInfo(mainBusinessCode, deliveryCode);
		if(CommonUtils.isEmpty(deliveryInfo)) return null;
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("deliveryInfo", deliveryInfo);
		
		//물류이동 사유
		int stockReasonCode = deliveryInfo.getStockReasonCode();
		if(stockReasonCode == 5) {
			//출하계획
			resultMap.put("shipPlanDetails", deliveryMapper.getShipPlanDetails(deliveryInfo.getShipmentPlanCode()));
		} else if(stockReasonCode == 7) {
			//반품요청
			resultMap.put("returnRegDetails", deliveryMapper.getReturnRegDetails(deliveryInfo.getReturnRegCode()));
		}
		
		return resultMap;
	}
	
	/**
	 * 운송요청내역 등록 프로세스
	 * @param mainBusinessCode
	 * @param dInfo
	 * @return 성공 시 true, 실패 시 false
	 */
	public boolean addDelivery(String mainBusinessCode, Delivery dInfo) {
		//운송요청내역 등록 프로세스
		return false;
	}
	
	/**
	 * 운송요청내역 수정 프로세스
	 * @param mainBusinessCode
	 * @param dInfo
	 * @return 성공 시 true, 실패 시 false
	 */
	public boolean modifyDelivery(String mainBusinessCode, Delivery dInfo) {
		//운송요청내역 수정 프로세스
		return false;
	}
	
	/**
	 * 운송요청내역 삭제 프로세스
	 * @param mainBusinessCode
	 * @param dInfo
	 */
	public void removeDelivery(String mainBusinessCode, Delivery dInfo) {
		//운송요청내역 수정 프로세스
	}
	
}
