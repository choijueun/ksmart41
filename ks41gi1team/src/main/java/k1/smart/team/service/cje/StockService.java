package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.common.CommonUtils;
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
		if(CommonUtils.isEmpty(stockInfo)) return null;
		//해당 재고의 물류이동 내역 조회
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
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("stockInfo", stockInfo);
		resultMap.put("storingList", storingList);
		
		return resultMap;
	}
	
	/**
	 * 재고 수량/중량 검사
	 * @param mainBusinessCode
	 * @param inventoryCode
	 * @return E: 에러 / Y: 수량중량0(삭제가능) / N: 삭제 불가능
	 */
	public char stockRemoveValid(String mainBusinessCode, String inventoryCode) {
		Map<String, Object> resultMap = stockMapper.stockRemoveValid(mainBusinessCode, inventoryCode);
		if(CommonUtils.isEmpty(resultMap)) {
			return 'E';
		}
		if ( (int) resultMap.get("itemCount") == 0 && (int) resultMap.get("stockWeight") == 0) {
			return 'Y';
		}
		
		return 'N';
	}
	
	public void removeStock(String mainBusinessCode, String inventoryCode) {
		stockMapper.removeAdjDetailByStock(mainBusinessCode, inventoryCode);
		stockMapper.removeStock(mainBusinessCode, inventoryCode);
	}
}
