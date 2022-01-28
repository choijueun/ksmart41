package k1.smart.team.mapper.cje;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StoringMapper {
	/**
	 * 물류이동내역 전체조회
	 * @param mainBusinessCode
	 * @param stockReasonCode
	 */
	public List<Storing> getAllStoringList(Map<String, Object> paramMap);
	
	/**
	 * 물류이동내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @param stockReasonCode
	 */
	public Storing getStoringInfo(String mainBusinessCode, String stockAdjCode, String stockReasonCode);
	
	/**
	 * 최근 7일간 물류이동 횟수(사유별)
	 * @param mainBusinessCode
	 */
	public Map<String,Object> getRecentStoring(String mainBusinessCode);
	
	/**
	 * 최근 7일간 날짜별 생산·출하 횟수
	 * @param mainBusinessCode
	 */
	public List<Map<String, Object>> getRecentProShip(String mainBusinessCode);
	
	/**
	 * 완료되지 않은 배송요청 건수 조회
	 * @param mainBusinessCode
	 */
	public int unfinishedDeliveryCnt(String mainBusinessCode);
	
	/**
	 * 완료되지 않은 출하계획 건수 조회
	 * @param mainBusinessCode
	 */
	public int unfinishedShipmentCnt(String mainBusinessCode);
	
	/**
	 * 완료되지 않은 반품요청 건수 조회
	 * @param mainBusinessCode
	 */
	public int unfinishedReturnCnt(String mainBusinessCode);
	
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
	
	/**
	 * 등록화면에 넣을 재고정보 하나
	 * @param mainBusinessCode
	 * @param inventoryCode
	 */
	public Stock getStockForStoring(String mainBusinessCode, String inventoryCode);
	
	/**
	 * 물류이동내역 등록
	 * @param storingInfo
	 */
	public int addStoringInfo(Storing storingInfo); //한줄테이블
	public int addStoringDetails(Stock stockInfo); //상세테이블
	
	/**
	 * 물류이동내역 수정
	 * @param storingInfo
	 */
	public int modifyStoringInfo(Storing storingInfo);//한줄테이블
	public int modifyStoringDetails(Stock stockInfo); //상세테이블
	
	/**
	 * 물류이동내역 삭제
	 * @param stockAdjCode
	 */
	public int removeStoringInfo(Map<String, Object> paramMap); //한줄테이블
	public int removeStoringDetails(Map<String, Object> paramMap); //상세테이블
	
	
	/*************************
			출하계획
	*************************/
	
	/**
	 * 출하계획 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getShipmentPlanList(String mainBusinessCode);
	
	/**
	 * 출하계획 상세정보
	 * @param mainBusinessCode
	 * @param shipmentPlanCode
	 */
	public Storing getShipmentPlanInfo(String mainBusinessCode, String shipmentPlanCode);
	//출하계획 상세정보 배열
	public List<Storing> getShipmentPlanDetails(String shipmentPlanCode);
	
	/**
	 * 출하계획 수정
	 * @param storingInfo
	 */
	public int modifyShipmentPlanInfo(Storing storingInfo);//한줄테이블
	public int modifyShipmentPlanDetails(Stock stockInfo); //상세테이블
	
	/**
	 * 출하계획 삭제
	 * @param stockAdjCode
	 */
	public void removeShipmentPlanInfo(String stockAdjCode, String mainBusinessCode); //한줄테이블
	public void removeShipmentPlanDetails(String stockAdjCode, String stockAdjDetailCode); //상세테이블
	
	
	/*************************
			반품요청
	 *************************/
	
	/**
	 * 반품요청 전체조회
	 * @param mainBusinessCode
	 */
	public List<Storing> getReturnRegList(String mainBusinessCode);
	
	/**
	 * 반품요청 상세조회
	 * @param returnRegCode
	 */
	public Storing getReturnRegInfo(String returnRegCode);
	public List<Storing> getReturnRegDetails(String returnRegCode);
	
	/**
	 * 반품요청 수정
	 * @param storingInfo
	 */
	public int modifyReturnRegInfo(Storing storingInfo);//한줄테이블
	public int modifyReturnRegDetails(Stock stockInfo); //상세테이블
	
	/**
	 * 반품요청 삭제
	 * @param stockAdjCode
	 */
	public void removeReturnRegInfo(String stockAdjCode, String mainBusinessCode); //한줄테이블
	public void removeReturnRegDetails(String stockAdjCode, String stockAdjDetailCode); //상세테이블
}