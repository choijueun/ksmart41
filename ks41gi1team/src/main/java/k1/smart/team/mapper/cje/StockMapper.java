package k1.smart.team.mapper.cje;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StockMapper {
	/**
	 * 재고정보 전체조회
	 * @param mainBusinessCode
	 * @return 재고 여러개 정보
	 */
	public List<Stock> getAllStockList(String types, String wList, String mainBusinessCode);
	
	/**
	 * 재고정보 상세조회
	 * @param inventoryCode
	 * @return 재고 하나 정보
	 */
	public Stock getStockInfo(String mainBusinessCode, String inventoryCode);
	//특정 재고의 물류이동내역 조회
	public List<Storing> getStockStorings(String inventoryCode);
	
	//재고의 수량·중량이 0인지 검사
	public Map<String, Object> stockRemoveValid(String mainBusinessCode, String inventoryCode);
	
	/**
	 * 재고정보 등록
	 * @param itemInfo
	 */
	public int addStock(Stock stock);
	
	/**
	 * 재고정보 수정
	 * @param itemInfo
	 */
	public int modifyStock(Stock stock);
	
	/**
	 * 수량·중량 0인 재고 모두 삭제
	 * @param mainBusinessCode
	 */
	public void cleanStock(String mainBusinessCode);
	
	/**
	 * 재고정보 삭제
	 * @param stock
		 */
	public int removeStock(Map<String, Object> paramMap);

}
