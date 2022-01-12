package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class MaterialUseService {
	private StoringMapper storingMapper;
	private Storing materialUseInfo; //자재사용내역 하나
	private List<Storing> materialUseList; //자재사용내역 배열
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public MaterialUseService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 자재사용내역 전체목록 조회
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Storing> getAllMaterialUseList(String mainBusinessCode) {
		materialUseList = storingMapper.getAllStoringList(mainBusinessCode, "2");
		
		return materialUseList;
	}
	
	/**
	 * 자재사용내역 상세정보 조회
	 * @param mainBusinessCode
	 * @param stockAdjCode
	 * @return materialUseInfo & materialUseDetails
	 */
	public Map<String, Object> getMaterialUseInfo(String mainBusinessCode, String stockAdjCode) {
		
		materialUseInfo = storingMapper.getStoringInfo(mainBusinessCode, stockAdjCode, "2");
		if(materialUseInfo == null) return null;
		materialUseList = storingMapper.getMaterialUseDetails(stockAdjCode);
		
		resultMap.clear();
		resultMap.put("materialUseInfo", materialUseInfo);
		resultMap.put("materialUseDetails", materialUseList);
		
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
