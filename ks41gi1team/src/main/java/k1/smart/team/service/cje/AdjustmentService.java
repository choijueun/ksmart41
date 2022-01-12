package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class AdjustmentService {
	private StoringMapper storingMapper;;
	private List<Storing> adjList; //재고조정내역 배열
	private Storing adjInfo; //재고조정내역 상세정보
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param adjMapper
	 */
	public AdjustmentService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	/**
	 * 재고조정내역 전체조회
	 * @param mainBusinessCode
	 * @return 재고조정내역 여러개(List<Storing>)
	 */
	public List<Storing> getAllAdjList(String mainBusinessCode) {
		adjList = storingMapper.getAllStoringList(mainBusinessCode, "6");
		
		return adjList;
	}
	
	/**
	 * 재고조정내역 상세조회
	 * @param stockAdjCode
	 * @return
	 */
	public Map<String, Object> getAdjInfo(String mainBusinessCode, String stockAdjCode) {
		//한줄정보
		adjInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "6");
		if(adjInfo == null) return null;
		//상세정보(배열)
		adjList = storingMapper.getAdjDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("adjInfo", adjInfo);
		resultMap.put("adjDetailList", adjList);
		
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
