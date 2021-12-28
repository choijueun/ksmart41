package k1.smart.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.Stock;

@Mapper
public interface StockMapper {
	public List<Stock> getAllStockList(String mainBusinessCode);
	
	public List<Stock> getStockInfo(String mainBusinessCode, String inventoryCode);
}
