package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.dto.cje.Stock;

@Mapper
public interface DeliveryMapper {
	/**
	 * 전체 운송내역 조회
	 * @param mainBusinessCode
	 */
	public List<Delivery> getAllDeliveryList(String mainBusinessCode);
	
	/**
	 * 운송내역 상세조회
	 * @param mainBusinessCode
	 * @param deliveryCode
	 */
	public Delivery getDeliveryInfo(String mainBusinessCode, String deliveryCode);
	//출하계획
	public List<Stock> getShipPlanDetails(String shipmentPlanCode);
	//반품요청
	public List<Stock> getReturnRegDetails(String returnRegCode);
	
}
