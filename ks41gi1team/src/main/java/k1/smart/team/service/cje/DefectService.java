package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class DefectService {
	private StoringMapper storingMapper;
	private List<Storing> defectList; //불량처리내역 배열
	private Storing defectInfo; //불량처리내역 정보
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public DefectService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 불량처리내역 전체목록 조회
	 * @param mainBusinessCode
	 * @return 불량처리내역 배열
	 */
	public List<Storing> getAllDefectList(String mainBusinessCode){
		defectList = storingMapper.getAllStoringList(mainBusinessCode, "8");
		
		return defectList;
	}
	
	/**
	 * 불량처리내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return 불량처리내역 한줄&상세
	 */
	public Map<String, Object> getDefectInfo(String mainBusinessCode, String stockAdjCode) {
		defectInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "8");
		if(defectInfo == null) return null;
		
		defectList = storingMapper.getDefectDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("defectInfo", defectInfo);
		resultMap.put("defectDetail", defectList);
		
		return resultMap;
	}

}
