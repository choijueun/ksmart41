package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.CodeMapper;

@Mapper
public interface StockMapper extends CodeMapper {
	//재고정보 전체조회
	public List<Stock> getAllStockList(String mainBusinessCode);
	
	//재고정보 상세조회
	public List<Stock> getStockInfo(String mainBusinessCode, String inventoryCode);
}
