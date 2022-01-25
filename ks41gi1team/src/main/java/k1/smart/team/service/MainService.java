package k1.smart.team.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.mapper.cje.StoringMapper;

@Service
@Transactional
public class MainService {
	@Autowired
	private StoringMapper storingMapper;
	
	/**
	 * 미완 배송요청·출하계획·반품요청 건수 조회
	 * @param mainBusinessCode
	 */
	public Map<String, Object> getUnfinishedCnt(String mainBusinessCode) {
		//map 객체 생성
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("unfinishedDeliveryCnt", storingMapper.unfinishedDeliveryCnt(mainBusinessCode));
		resultMap.put("unfinishedShipmentCnt", storingMapper.unfinishedShipmentCnt(mainBusinessCode));
		resultMap.put("unfinishedReturnCnt", storingMapper.unfinishedReturnCnt(mainBusinessCode));
		
		return resultMap;
	}
}
