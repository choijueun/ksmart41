package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class WarehousingService {
	private StoringMapper storingMapper;
	private Storing warehousingInfo; //자재사용내역 하나
	private List<Storing> warehousingList; //자재사용내역 배열
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public WarehousingService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 입고내역 전체조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getAllWarehousingList(String mainBusinessCode) {
		warehousingList = storingMapper.getAllStoringList(mainBusinessCode, "1");
		
		return warehousingList;
	}
	
	/**
	 * 입고내역 상세조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String, Object> getWarehousingInfo(String mainBusinessCode, String stockAdjCode) {
		warehousingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "1");
		if(warehousingInfo == null) return null;
		warehousingList = storingMapper.getWarehousingDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("warehousingInfo", warehousingInfo);
		resultMap.put("warehousingDetails", warehousingList);
		
		return resultMap;
	}

}
