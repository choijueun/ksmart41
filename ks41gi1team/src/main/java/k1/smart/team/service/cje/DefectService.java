package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class DefectService {
	private StoringMapper storingMapper;
	private List<Storing> defectList; //불량처리내역 배열
	private Storing defectInfo; //불량처리내역 정보
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
		
		if(defectList == null) return null;
		
		return defectList;
	}
	
	/**
	 * 불량처리내역 상세정보 조회
	 * @param stockAdjCode
	 * @return 불량처리내역 하나 정보
	 */
	public Storing getDefectInfo(String mainBusinessCode, String stockAdjCode) {
		defectInfo = storingMapper.getDefectInfo(mainBusinessCode, stockAdjCode);
		if(defectInfo == null) return null;
		
		return defectInfo;
	}
	public List<Storing> getDefectDetailInfo(String stockAdjCode) {
		defectList = storingMapper.getDefectDetailInfo(stockAdjCode);
		if(defectList == null) return null;
		
		return defectList;
	}

}
