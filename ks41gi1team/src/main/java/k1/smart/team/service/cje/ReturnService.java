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
	private List<Storing> returnList; //반품처리내역 배열
	private Storing returnInfo; //반품처리내역 하나
	
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
		returnList = storingMapper.getAllStoringList(mainBusinessCode, "7");
		
		return returnList;
	}
	
	/**
	 * 반품처리내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String, Object> getReturnInfo(String mainBusinessCode, String stockAdjCode) {
		//반품처리내역 정보
		returnInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "7");
		if(CommonUtils.isEmpty(returnInfo)) return null;
		//반품처리내역 상세정보 조회
		returnList = storingMapper.getReturnDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("returnInfo", returnInfo);
		resultMap.put("returnDetails", returnList);
		
		return resultMap;
	}
	
	/**
	 * 반품요청내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getReturnRegList(String mainBusinessCode) {
		returnList = storingMapper.getReturnRegList(mainBusinessCode);
		
		return returnList;
	}
	
	/**
	 * 반품요청내역 상세조회
	 * @param returnRegCode
	 * @return
	 */
	public Map<String, Object> getReturnRegInfo(String returnRegCode) {
		//반품요청내역 정보
		returnInfo = storingMapper.getReturnRegInfo(returnRegCode);
		if(CommonUtils.isEmpty(returnInfo)) return null;
		//반품요청내역 상세정보 배열
		returnList = storingMapper.getReturnRegDetails(returnRegCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("returnRegInfo", returnInfo);
		resultMap.put("returnRegDetails", returnList);
		
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
