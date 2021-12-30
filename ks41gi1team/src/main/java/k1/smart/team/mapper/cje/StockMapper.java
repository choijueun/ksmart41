package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;

@Mapper
public interface StockMapper {
	/**
	 * 재고정보 전체조회
	 * @param mainBusinessCode
	 * @return 재고 여러개 정보
	 */
	public List<Stock> getAllStockList(String mainBusinessCode);
	
	/**
	 * 재고정보 상세조회
	 * @param inventoryCode
	 * @return 재고 하나 정보
	 */
	public Stock getStockInfoByCode(String inventoryCode);
}
