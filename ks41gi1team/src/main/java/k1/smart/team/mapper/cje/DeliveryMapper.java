package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Delivery;
import k1.smart.team.dto.cje.Storing;

@Mapper
public interface DeliveryMapper {
	//전체 운송내역 조회
	public List<Delivery> getAllDeliveryList(String mainBusinessCode);
	
	//운송내역 상세조회
	public Delivery getDeliveryInfo(String mainBusinessCode, String deliveryCode);
	//출하계획
	public List<Storing> getShipPlanDetails(String shipmentPlanCode);
	//반품요청
	public List<Storing> getReturnRegDetails(String returnRegCode);
	
}
