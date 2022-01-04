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
	
	public List<Storing> getAllDefectList(String mainBusinessCode){
		defectList = storingMapper.getAllStoringList(mainBusinessCode, "8");
		return defectList;
	}

}
