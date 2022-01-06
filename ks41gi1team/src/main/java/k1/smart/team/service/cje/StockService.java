package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StockMapper;

@Service
@Transactional
public class StockService {
	private StockMapper stockMapper;
	private List<Stock> stockList; //재고 여러개 정보
	private Stock stockInfo; //재고 하나 정보
	private Storing storingInfo; //재고조정내역 상세정보
	private List<Storing> storingList; //재고조정내역 상세정보
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	/**
	 * 생성자 메서드
	 * @param stockMapper
	 */
	public StockService(StockMapper stockMapper) {
		this.stockMapper = stockMapper;
	}

	/**
	 * 재고 전체목록 조회
	 * @param mainBusinessCode
	 * @return 재고 여러개 정보
	 */
	public List<Stock> getAllStockList(String mainBusinessCode){
		stockList = stockMapper.getAllStockList(mainBusinessCode);
		return stockList;
	}
	
	/**
	 * 재고 상세정보 조회
	 * @param inventoryCode
	 * @return 재고 하나 정보
	 */
	public Map<String, Object> getStockInfo(String mainBusinessCode, String inventoryCode) {
		//재고정보
		stockInfo = stockMapper.getStockInfo(mainBusinessCode, inventoryCode);
		if(stockInfo == null) return null;
		storingList = stockMapper.getStockStorings(inventoryCode);
		
		//물류이동 사유
		if(storingList != null) {
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
		}
		
		resultMap.clear();
		resultMap.put("stockInfo", stockInfo);
		resultMap.put("storingList", storingList);
		
		return resultMap;
	}
}
