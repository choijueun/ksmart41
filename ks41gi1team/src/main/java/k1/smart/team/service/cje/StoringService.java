package k1.smart.team.service.cje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
@Transactional
public class StoringService {
	private StoringMapper storingMapper;
	private Storing storingInfo; //물류
	private List<Storing> storingList; //물류 배열
	
	@Autowired
	private CodeMapper codeMapper; //코드번호 자동생성
	@Autowired
	private StockService stockService; //재고검색
	
	private static final Logger log = LoggerFactory.getLogger(StoringService.class);
	
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public StoringService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 물류이동내역 전체목록 조회
	 * @param mainBusinessCode
	 * @return List<Storing>
	 */
	public Map<String, Object> getAllStoringList(Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String mainBusinessCode = (String) paramMap.get("mainBusinessCode");
		//물류이동 내역
		storingList = storingMapper.getAllStoringList(paramMap);
		//최근 물류이동 현황
		resultMap.put("recentStoring", storingMapper.getRecentStoring(mainBusinessCode));
		//최근 생산·출하 현황
		resultMap.put("recentProShip", storingMapper.getRecentProShip(mainBusinessCode));
		
		//물류이동내역이 없다면
		if(CommonUtils.isEmpty(storingList)) {
			resultMap.put("storingList", null);
			return resultMap;
		}
		
		//물류이동 사유
		int stockReasonCode;
		for(int i=0; i<storingList.size(); i++) {
			storingInfo = storingList.get(i);
			stockReasonCode = storingInfo.getStockReasonCode();
			if(stockReasonCode == 1) storingInfo.setStockReasonEng("Warehousing");
			else if(stockReasonCode == 2) storingInfo.setStockReasonEng("MaterialUse");
			else if(stockReasonCode == 3) storingInfo.setStockReasonEng("Production");
			else if(stockReasonCode == 4) storingInfo.setStockReasonEng("Moving");
			else if(stockReasonCode == 5) storingInfo.setStockReasonEng("Shipment");
			else if(stockReasonCode == 6) storingInfo.setStockReasonEng("Adjustment");
			else if(stockReasonCode == 7) storingInfo.setStockReasonEng("Return");
			else if(stockReasonCode == 8) storingInfo.setStockReasonEng("Defect");
		}
		resultMap.put("storingList", storingList);
		return resultMap;
	}
	
	/**
	 * 재고정보 하나 조회 for 등록화면
	 * @param mainBusinessCode
	 * @param inventoryCode
	 */
	public Stock getStockForStoring(String mainBusinessCode, String inventoryCode) {
		
		return storingMapper.getStockForStoring(mainBusinessCode, inventoryCode);
	}
	
	
	/**
	 * 1. 입고내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 */
	public Map<String, Object> getWarehousingInfo(String mainBusinessCode, String stockAdjCode) {
		//입고내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "1");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//입고내역 상세정보 배열
		storingList = storingMapper.getWarehousingDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("warehousingInfo", storingInfo);
		resultMap.put("warehousingDetails", storingList);
		
		return resultMap;
	}

	
	/**
	 * 2. 자재사용내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return materialUseInfo & materialUseDetails
	 */
	public Map<String, Object> getMaterialUseInfo(String mainBusinessCode, String stockAdjCode) {
		//자재사용내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "2");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//자재사용내역 상세정보 배열
		storingList = storingMapper.getMaterialUseDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("materialUseInfo", storingInfo);
		resultMap.put("materialUseDetails", storingList);
		
		return resultMap;
	}
	
	
	/**
	 * 3. 제품생산내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 */
	public Map<String, Object> getProductionInfo(String mainBusinessCode, String stockAdjCode) {
		//제품생산내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "3");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//제품생산내역 상세정보 배열
		storingList = storingMapper.getProductionDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("productionInfo", storingInfo);
		resultMap.put("productionDetails", storingList);
		
		return resultMap;
	}
	
	
	/**
	 * 4. 창고이동내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 */
	public Map<String,Object> getMovingInfo(String mainBusinessCode, String stockAdjCode) {
		//창고이동내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "4");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//창고이동내역 상세정보 배열
		storingList = storingMapper.getMovingDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("movingInfo", storingInfo);
		resultMap.put("movingDetails", storingList);
		
		return resultMap;
	}
	
	
	/**
	 * 5. 출하내역 상세조회
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
	 * 5-2. 출하계획 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getShipmentPlanList(String mainBusinessCode) {
		return storingMapper.getShipmentPlanList(mainBusinessCode);
	}
	
	/**
	 * 5-2. 출하계획 상세조회
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
	 * 6. 재고조정내역 상세조회
	 * @param stockAdjCode
	 * @return 한줄(Storing)&상세(List<Storing>)
	 */
	public Map<String, Object> getAdjInfo(String mainBusinessCode, String stockAdjCode) {
		//한줄정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "6");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//상세정보(배열)
		storingList = storingMapper.getAdjDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("adjInfo", storingInfo);
		resultMap.put("adjDetailList", storingList);
		
		return resultMap;
	}
	
	
	/**
	 * 7. 반품처리내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 */
	public Map<String, Object> getReturnInfo(String mainBusinessCode, String stockAdjCode) {
		//반품처리내역 정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "7");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//반품처리내역 상세정보 조회
		storingList = storingMapper.getReturnDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("returnInfo", storingInfo);
		resultMap.put("returnDetails", storingList);
		
		return resultMap;
	}
	
	/**
	 * 7-2. 반품요청내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getReturnRegList(String mainBusinessCode) {
		return storingMapper.getReturnRegList(mainBusinessCode);
	}
	
	/**
	 * 7-2. 반품요청내역 상세조회
	 * @param returnRegCode
	 * @return
	 */
	public Map<String, Object> getReturnRegInfo(String returnRegCode) {
		//반품요청내역 정보
		storingInfo = storingMapper.getReturnRegInfo(returnRegCode);
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//반품요청내역 상세정보 배열
		storingList = storingMapper.getReturnRegDetails(returnRegCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("returnRegInfo", storingInfo);
		resultMap.put("returnRegDetails", storingList);
		
		return resultMap;
	}
	
	
	/**
	 * 8. 불량처리내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return 불량처리내역 한줄&상세
	 */
	public Map<String, Object> getDefectInfo(String mainBusinessCode, String stockAdjCode) {
		//불량처리내역 한줄정보 조회
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "8");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		
		//불량처리내역 상세정보 배열
		storingList = storingMapper.getDefectDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("defectInfo", storingInfo);
		resultMap.put("defectDetail", storingList);
		
		return resultMap;
	}
	
	/**
	 * 물류이동내역 등록 프로세스
	 * @param storingInfo
	 * @return 성공시 true, 실패시 false
	 */
	public boolean addStoringInfo(Storing storingInfo) {
		//사업장대표코드
		String mainBusinessCode = storingInfo.getMainBusinessCode();
		//창고코드
		String warehouseCode = this.getWCodeForStock(storingInfo);
		
		//물류이동코드 생성
		String stockAdjCode = codeMapper.getNewCodeNum("k1_tb_stock_adjustment", "stockAdjCode");
		//물류이동코드 SET
		storingInfo.setStockAdjCode(stockAdjCode);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("stockAdjCode", stockAdjCode);
		
		log.info("1. 물류이동내역 등록 :: storingInfo = {}",storingInfo);
		if(storingMapper.addStoringInfo(storingInfo) == 0) {
			//실패시 return false
			return false;
		}
		
		List<Stock> itemList = new ArrayList<Stock>();
		//itemCode, itemCount, itemWeight 없는 정보 제외
		for(Stock itemInfo : storingInfo.getS()) {
			if(CommonUtils.isEmpty(itemInfo.getItemCode())
				|| CommonUtils.isEmpty(itemInfo.getItemCount())
				|| CommonUtils.isEmpty(itemInfo.getItemWeight())) {
				continue;
			}
			itemList.add(itemInfo);
		}
		
		//totalCount, totalWeight 계산
		itemList = this.plusStockStoring(mainBusinessCode, warehouseCode, itemList);
		log.info("2. 재고정보 완성 :: itemList = {}",itemList);
		if(CommonUtils.isEmpty(itemList)) {
			//실패
			//물류이동내역(stockAdjCode) 삭제
			storingMapper.removeStoringInfo(paramMap);
			return false;
		}
		
		String stockAdjDetailCode = null;
		//상세정보 반복문
		for(Stock itemInfo : itemList) {
			//물류이동코드 SET
			itemInfo.setStockAdjCode(stockAdjCode);
			//물류이동상세코드 GET&SET
			stockAdjDetailCode = codeMapper.getNewCodeNum("k1_tb_stock_adjustment_detail", "stockAdjDetailCode");
			itemInfo.setStockAdjDetailCode(stockAdjDetailCode);
			//purchaseTsCode 또는  salesTsCode 존재시 unitPrice 초기화
			if(!CommonUtils.isEmpty(itemInfo.getPurchaseTsCode()) || !CommonUtils.isEmpty(itemInfo.getSalesTsCode())) {
				itemInfo.setUnitPrice(0);
			}
			//3. 물류이동 상세내역 등록 프로세스
			log.info("3. 물류이동 상세내역 등록 :: itemInfo = {}",itemInfo);
			if(storingMapper.addStoringDetails(itemInfo) == 0) {
				//실패
				//물류이동상세내역(stockAdjDetailCode) 삭제
				storingMapper.removeStoringDetails(paramMap);
				//물류이동내역(stockAdjCode) 삭제
				storingMapper.removeStoringInfo(paramMap);
				return false;
			}
		}
		log.info("4. 재고정보 갱신 :: itemList = {}",itemList);
		boolean chk = false;
		for(Stock itemInfo : itemList) {
			if(CommonUtils.isEmpty(itemInfo.getInventoryCode())) {
				//재고코드 없으면 INSERT 
				chk = stockService.addStock(itemInfo);
			}else {
				//재고코드 있으면 UPDATE
				chk = stockService.modifyStock(itemInfo);
			}
			if(!chk) return false;
		}
		
		//모든 정보 등록 완료
		return true;
	}
	
	/**
	 * 재고에 set할 창고코드
	 * @param storingInfo
	 */
	public String getWCodeForStock(Storing storingInfo) {
		//물류이동 사유
		int stockReasonCode = storingInfo.getStockReasonCode();
		//창고코드
		String warehouseCode = null;
		if( stockReasonCode == 1 || stockReasonCode == 2 || stockReasonCode == 3 
				|| stockReasonCode == 5 || stockReasonCode == 8 ) {
			//1. 입고&자재사용&생산제품출하&불량(일방향)
			if(CommonUtils.isEmpty(storingInfo.getReceiveWarehouse())) {
				warehouseCode = storingInfo.getSendWarehouse();
			}else if(CommonUtils.isEmpty(storingInfo.getSendWarehouse())) {
				warehouseCode = storingInfo.getReceiveWarehouse();
			}
		}else if ( stockReasonCode == 4 || stockReasonCode == 6 || stockReasonCode == 7 ) {
			//2. 창고이동&재고차이&반품
			//생각좀더하고…
		}
		
		return warehouseCode;
	}
	
	/**
	 * 추가할 재고 목록 - 기존 재고에 수량중량 합함
	 * @param mainBusinessCode & warehouseCode : 재고검색 조건
	 * @param itemList : 추가할 품목
	 * @return totalWeight, totalCount 계산 후 List<Stock>
	 */
	public List<Stock> plusStockStoring(String mainBusinessCode,String warehouseCode, List<Stock> itemList) {
		//return할 품목정보 목록
		List<Stock> returnList = new ArrayList<Stock>();
		
		//사업장대표코드 및 창고코드 일치하는 재고 검색
		List<Stock> stockList = stockService.getAllStockList(null, warehouseCode, mainBusinessCode);
		
		if(CommonUtils.isEmpty(stockList)) {
			log.info("1) 사업장대표코드 및 창고코드 일치하는 재고정보 없다");
			for (Stock itemInfo : itemList) {
				//사업장대표코드 및 창고코드
				itemInfo.setMainBusinessCode(mainBusinessCode);
				itemInfo.setWarehouseCode(warehouseCode);
				//수량 및 중량
				itemInfo.setTotalCount(itemInfo.getItemCount());
				itemInfo.setTotalWeight(itemInfo.getItemWeight());
				//반환List에 추가
				returnList.add(itemInfo);
			}
			return returnList;
		}
		
		log.info("2) 사업장대표코드 및 창고코드 일치하는 재고정보 있다");
		String itemCode = null;
		String inventoryCode = null;
		boolean chk = true;
		for(Stock itemInfo : itemList) {
			//사업장대표코드 및 창고코드
			itemInfo.setMainBusinessCode(mainBusinessCode);
			itemInfo.setWarehouseCode(warehouseCode);
			//품목코드 일치 확인
			itemCode = itemInfo.getItemCode();
			//재고정보 반복문
			for(Stock stockInfo : stockList) {
				inventoryCode = stockInfo.getInventoryCode();
				if(itemCode.equals(stockInfo.getItemCode())) {
					log.info("2-1) 일치하는 품목  있다 :: inventoryCode = {}",inventoryCode);
					//재고코드
					itemInfo.setInventoryCode(inventoryCode);
					//수량 및 중량
					itemInfo.setTotalCount(itemInfo.getItemCount() + stockInfo.getTotalCount());
					itemInfo.setTotalWeight(itemInfo.getItemWeight() + stockInfo.getTotalWeight());
					chk = false;
					break;
				}
			}
			//기존 재고가 있다면 아래 코드는 실행하지 않는다.
			if(chk) {
				log.info("2-2) 일치하는 품목  없다");
				//수량 및 중량
				itemInfo.setTotalCount(itemInfo.getItemCount());
				itemInfo.setTotalWeight(itemInfo.getItemWeight());
			}
		}
		return itemList;
	}
	
	/**
	 * 감소할 재고 목록 - 기존 재고에 수량중량 뺀다
	 * @param mainBusinessCode
	 * @param warehouseCode
	 * @param itemList
	 * @return totalWeight, totalCount 계산 후 List<Stock>
	 */
	public List<Stock> minusStockStoring(String mainBusinessCode,String warehouseCode, List<Stock> itemList) {
		
		return null;
	}
	
	/**
	 * 물류이동내역(한줄) 삭제
	 * @param storing
	 */
	public int removeStoringInfo(Map<String, Object> paramMap) {
		log.info("삭제할 stockAdj - paramMap :: {}", paramMap);
		//물류이동내역(상세) 삭제
		this.removeStoringDetails(paramMap);
		//물류이동내역(한줄) 삭제
		return storingMapper.removeStoringInfo(paramMap);
	}
	
	/**
	 * 물류이동내역(상세) 삭제
	 * @param storing
	 */
	public int removeStoringDetails(Map<String, Object> paramMap) {
		return storingMapper.removeStoringDetails(paramMap);
	}
	
}
