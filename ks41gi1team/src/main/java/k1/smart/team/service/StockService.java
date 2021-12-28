package k1.smart.team.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.Stock;
import k1.smart.team.mapper.StockMapper;

@Service
@Transactional
public class StockService {
	private StockMapper stockMapper;
	private List<Stock> stockList = null;

	//재고 전체 목록 조회
	public List<Stock> getAllStockList(String mainBusinessCode){
		stockList = stockMapper.getAllStockList(mainBusinessCode);
		return stockList;
	}
}
