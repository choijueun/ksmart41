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
	
	public Map<String, Object> getReturnInfo(String mainBusinessCode, String stockAdjCode) {
		returnInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "7");
		returnList = storingMapper.getReturnDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("returnInfo", returnInfo);
		resultMap.put("returnDetails", returnList);
		
		return resultMap;
	}

}
