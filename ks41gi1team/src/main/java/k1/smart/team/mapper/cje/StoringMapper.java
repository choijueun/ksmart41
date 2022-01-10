package k1.smart.team.mapper.cje;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StoringMapper {
	//물류이동내역 전체조회
	public List<Storing> getAllStoringList(String mainBusinessCode, String stockReasonCode);
	//물류이동내역 상세조회
	public Storing getStoringInfo(String mainBusinessCode, String stockAdjCode, String stockReasonCode);
	
	//최근 7일간 물류이동 횟수(사유별)
	public Map<String,Object> getRecentStoring(String mainBusinessCode);
	
	//1. 자재입고 상세내역 배열
	public List<Storing> getWarehousingDetails(String stockAdjCode);
	
	//2. 자재사용 상세내역 배열
	public List<Storing> getMaterialUseDetails(String stockAdjCode);
	
	//3. 제품생산 상세내역 배열
	public List<Storing> getProductionDetails(String stockAdjCode);
	
	//4. 창고이동 상세내역 배열
	public List<Storing> getMovingDetails(String stockAdjCode);
	
	//5. 출하 상세내역 배열
	public List<Storing> getShipmentDetails(String stockAdjCode);
	
	//6. 재고차이조정 상세내역 배열
	public List<Storing> getAdjDetails(String stockAdjCode);
	
	//7. 반품처리 상세내역 배열
	public List<Storing> getReturnDetails(String stockAdjCode);
	
	//8. 불량처리 상세내역 배열
	public List<Storing> getDefectDetails(String stockAdjCode);
	
	//출하계획 전체조회
	public List<Storing> getShipmentPlanList(String mainBusinessCode);
	
	//출하계획 정보
	public Storing getShipmentPlanInfo(String mainBusinessCode, String shipmentPlanCode);
	//출하계획 상세정보 배열
	public List<Storing> getShipmentPlanDetails(String shipmentPlanCode);
	
	//반품요청 전체조회
	public List<Storing> getReturnRegList(String mainBusinessCode);
	
	//반품요청 상세조회
	public Storing getReturnRegInfo(String returnRegCode);
	public List<Storing> getReturnRegDetails(String returnRegCode);
}
