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
public class AdjustmentService {
	private StoringMapper storingMapper;;
	private Storing storingInfo; //재고조정내역 상세정보
	private List<Storing> storingList; //재고조정내역 배열
	/**
	 * 생성자 메서드
	 * @param adjMapper
	 */
	public AdjustmentService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	/**
	 * 재고조정내역 전체목록 조회
	 * @param mainBusinessCode
	 * @return 재고조정내역 여러개(List<Storing>)
	 */
	public List<Storing> getAllAdjList(String mainBusinessCode) {
		//재고조정내역 전체목록
		return storingMapper.getAllStoringList(mainBusinessCode, "6");
	}
	
	/**
	 * 재고조정내역 상세조회
	 * @param stockAdjCode
	 * @return 한줄(Storing)&상세(List<Storing>)
	 */
	public Map<String, Object> getAdjInfo(String mainBusinessCode, String stockAdjCode) {
		//한줄정보
		storingInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "6");
		if(CommonUtils.isEmpty(storingInfo)) return null;
		//상세정보(배열)
		storingList = storingMapper.getAdjDetails(stockAdjCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("adjInfo", storingInfo);
		resultMap.put("adjDetailList", storingList);
		
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
