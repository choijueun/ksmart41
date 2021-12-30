package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.cje.StockMapper;

@Service
@Transactional
public class StockService {
	private StockMapper stockMapper;
	private List<Stock> stockList; //재고 여러개 정보
	private Stock stockInfo; //재고 하나 정보
	
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
		String stockNum;
		for(int i=0; i<stockList.size(); i++) {
			stockInfo = stockList.get(i);
			stockNum = stockInfo.getInventoryCode().replace("inventoryCode_", "");
			stockInfo.setInventoryCode(stockNum);
		}
		return stockList;
	}
	
	/**
	 * 재고 상세정보 조회
	 * @param inventoryCode
	 * @return 재고 하나 정보
	 */
	public Stock getStockInfoByCode(String inventoryCode) {
		if(inventoryCode == null || "".equals(inventoryCode)) {
			System.out.println("재고코드 NULL");
			return null;
		}
		stockInfo = stockMapper.getStockInfoByCode("inventoryCode_"+inventoryCode);
		
		if(stockInfo == null) {
			System.out.println("재고정보 조회결과 없음 - 재고코드 ERROR");
			return null;
		}
		stockInfo.setInventoryCode(inventoryCode);
		return stockInfo;
	}
}
