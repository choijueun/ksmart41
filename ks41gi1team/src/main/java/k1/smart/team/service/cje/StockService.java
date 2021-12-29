package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.cje.StockMapper;

@Service
@Transactional
public class StockService {
	private StockMapper stockMapper;
	private List<Stock> stockList;
	
	//생성자 메서드
	public StockService(StockMapper stockMapper) {
		this.stockMapper = stockMapper;
	}

	//재고 전체 목록 조회
	public List<Stock> getAllStockList(String mainBusinessCode){
		stockList = stockMapper.getAllStockList(mainBusinessCode);
		String newCodeNum = codeMapper.getNewCodeNum("inventoryCode", "k1_tb_stock");
		
		//String stockNum;
		for(int i=0; i<stockList.size(); i++) {
			//stockNum = stockList.get(i).getInventoryCode().replace("inventoryCode_", "");
			//stockList.get(i).setInventoryCode(stockNum);
			stockList.get(i).setInventoryCode(newCodeNum);
		}
		return stockList;
	}
}
