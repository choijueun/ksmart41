package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class StoringService {
	private StoringMapper storingMapper;
	private List<Storing> storingList; //물류 배열
	private Storing storingInfo; //물류
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public StoringService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 물류 전체목록 조회
	 * @param mainBusinessCode
	 * @return List<Storing>
	 */
	public Map<String, Object> getAllStoringList(String mainBusinessCode) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//물류이동 내역
		storingList = storingMapper.getAllStoringList(mainBusinessCode, null);
		//최근 물류이동 현황
		resultMap.put("recentStoring", storingMapper.getRecentStoring(mainBusinessCode));
		
		if(CommonUtils.isEmpty(storingList)) {
			resultMap.put("storingList", null);
			return resultMap;
		}
		
		//물류이동 사유
		int stockReasonCode;
		for(int i=0; i<storingList.size(); i++) {
			storingInfo = storingList.get(i);
			stockReasonCode = storingInfo.getStockReasonCode();
			if(stockReasonCode == 1) storingInfo.setStockReasonEng("Warehousing");
			else if(stockReasonCode == 2) storingInfo.setStockReasonEng("MaterialUse");
			else if(stockReasonCode == 3) storingInfo.setStockReasonEng("Production");
			else if(stockReasonCode == 4) storingInfo.setStockReasonEng("Moving");
			else if(stockReasonCode == 5) storingInfo.setStockReasonEng("Shipment");
			else if(stockReasonCode == 6) storingInfo.setStockReasonEng("Adjustment");
			else if(stockReasonCode == 7) storingInfo.setStockReasonEng("Return");
			else if(stockReasonCode == 8) storingInfo.setStockReasonEng("Defect");
		}
		resultMap.put("storingList", storingList);
		return resultMap;
	}

}
