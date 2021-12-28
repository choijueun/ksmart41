package k1.smart.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.Stock;

@Mapper
public interface StockMapper {
	//재고정보 전체조회
	public List<Stock> getAllStockList(String mainBusinessCode);
	
	//재고정보 상세조회
	public List<Stock> getStockInfo(String mainBusinessCode, String inventoryCode);
}
