package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.cje.WarehouseMapper;

@Service
public class WarehouseService {
	private WarehouseMapper warehouseMapper;
	private List<Warehouse> warehouseList; //창고 배열
	private Warehouse warehouseInfo; //창고 하나
	private List<Stock> itemList; //품목 배열
	
	@Autowired
	private CodeMapper codeMapper; //코드번호생성
	
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
	public List<Warehouse> getAllWarehouseList(String mainBusinessCode){
		//전체목록
		warehouseList = warehouseMapper.getWarehouseList(mainBusinessCode);
		//System.out.println("WarehouseService :: "+warehouseList);
		return warehouseList;
	}
	
	//나중에 SQL문 하나로 합치기
	
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

}
