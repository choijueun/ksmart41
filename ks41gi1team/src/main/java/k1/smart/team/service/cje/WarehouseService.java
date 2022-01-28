package k1.smart.team.service.cje;

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
import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.cje.StockMapper;
import k1.smart.team.mapper.cje.WarehouseMapper;

@Service
@Transactional
public class WarehouseService {
	private WarehouseMapper warehouseMapper;
	private List<Warehouse> warehouseList; //창고 배열
	private Warehouse warehouseInfo; //창고 하나
	private List<Stock> itemList; //품목 배열
	
	private static final Logger log = LoggerFactory.getLogger(WarehouseService.class);
	
	@Autowired
	private CodeMapper codeMapper; //코드번호생성
	@Autowired
	private StockMapper stockMapper; //재고
	@Autowired
	private StoringService storingService; //물류
	
	/**
	 * 생성자 메서드
	 * @param warehouseMapper
	 */
	public WarehouseService(WarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}
	
	/**
	 * 창고 전체목록 조회
	 * @param mainBusinessCode
	 * @return 창고 여러개 정보
	 */
	public List<Warehouse> getAllWarehouseList(Map<String, Object> paramMap){
		//전체목록
		warehouseList = warehouseMapper.getWarehouseList(paramMap);
		//System.out.println("WarehouseService :: "+warehouseList);
		return warehouseList;
	}
	
	/**
	 * 창고 상세정보 조회
	 * @param warehouseCode
	 * @return 창고 하나 정보
	 */
	public Map<String, Object> getWarehouseInfo(String mainBusinessCode, String warehouseCode) {
		//창고정보
		warehouseInfo = warehouseMapper.getWarehouseInfo(mainBusinessCode, warehouseCode);
		if(CommonUtils.isEmpty(warehouseInfo)) return null;
		//창고적재품 목록
		itemList = warehouseMapper.getWarehouseStock(warehouseCode);
			
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("warehouseInfo", warehouseInfo);
		resultMap.put("itemList", itemList);
		
		return resultMap;
	}
	
	/**
	 * 창고정보 등록 프로세스
	 * @param wInfo
	 * @return 성공시 true 실패시 false
	 */
	public boolean addWarehouse(Warehouse wInfo) {
		//공백 null치환
		if(CommonUtils.isEmpty(wInfo.getOutPlace())) wInfo.setOutPlace(null);
		//코드번호 생성
		wInfo.setWarehouseCode(codeMapper.getNewCodeNum("k1_tb_warehouse_info", "warehouseCode"));
		//등록프로세스 성공시1 실패시0
		int result = warehouseMapper.addWarehouse(wInfo);
		
		if(result > 0) return true;
		return false;
	}
	
	/**
	 * 창고정보 수정 프로세스
	 * @param wInfo
	 * @return 성공시 true 실패시 false
	 */
	public boolean modifyWarehouse(Warehouse wInfo) {
		//공백 null치환
		if(CommonUtils.isEmpty(wInfo.getOutPlace())) wInfo.setOutPlace(null);
		//수정프로세스 성공시1 실패시0
		int result = warehouseMapper.modifyWarehouse(wInfo);
		
		if(result > 0) return true;
		return false;
	}
	
	/**
	 * 창고정보 삭제 프로세스
	 * @param wInfo
	 */
	public void removeWarehouse(String warehouseList) {
		//map 생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for(String warehouseCode : warehouseList.split(",")) {
			//map 초기화
			paramMap.clear();
			//창고코드 입력
			paramMap.put("warehouseCode", warehouseCode);
			paramMap.put("sendWarehouse", warehouseCode);
			paramMap.put("receiveWarehouse", warehouseCode);
			//재고정보 삭제
			stockMapper.removeStock(paramMap);
			//물류이동내역 삭제
			storingService.removeStoringInfo(paramMap);
			//창고정보 삭제
			warehouseMapper.removeWarehouse(paramMap);
		}
	}

}
