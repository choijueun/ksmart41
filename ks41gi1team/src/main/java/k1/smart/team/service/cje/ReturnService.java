package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ReturnService {
	private StoringMapper storingMapper;
	private Storing storingInfo; //반품처리내역 하나
	private List<Storing> storingList; //반품처리내역 배열
	
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public ReturnService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 반품처리내역 전체조회
	 * @param mainBusinessCode
	 * @return 배열
	 */
	public List<Storing> getAllReturnList(String mainBusinessCode) {
		return storingMapper.getAllStoringList(mainBusinessCode, "7");
	}
	
	/**
	 * 반품처리내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
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
	 * 반품요청내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getReturnRegList(String mainBusinessCode) {
		return storingMapper.getReturnRegList(mainBusinessCode);
	}
	
	/**
	 * 반품요청내역 상세조회
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
	 * 재고정보 하나 조회
	 * @param mainBusinessCode
	 * @param inventoryCode
	 * @return
	 */
	public Stock getStockForStoring(String mainBusinessCode, String inventoryCode) {
		return storingMapper.getStockForStoring(mainBusinessCode, inventoryCode);
	}
}
