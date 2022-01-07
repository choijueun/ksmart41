package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ReturnService {
	private StoringMapper storingMapper;
	private List<Storing> returnList; //반품처리내역 배열
	private Storing returnInfo; //반품처리내역 하나
	private Map<String, Object> resultMap = new HashMap<String, Object>();
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
		returnInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "7");
		returnList = storingMapper.getReturnDetails(stockAdjCode);
		
		resultMap.clear();
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
		returnInfo = storingMapper.getReturnRegInfo(returnRegCode);
		if(returnInfo == null) return null;
		returnList = storingMapper.getReturnRegDetails(returnRegCode);
		
		resultMap.clear();
		resultMap.put("returnRegInfo", returnInfo);
		resultMap.put("returnRegDetails", returnList);
		
		return resultMap;
	}

}
