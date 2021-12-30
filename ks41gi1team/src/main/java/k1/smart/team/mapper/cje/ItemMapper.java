package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;

@Mapper
public interface ItemMapper {
	/**
	 * 품목정보 전체조회
	 * @param mainBusinessCode
	 * @return 품목 여러개 정보
	 */
	public List<Stock> getAllItemList(String mainBusinessCode);
	
	/**
	 * 품목정보 상세조회
	 * @param itemCode
	 * @return 품목 하나 정보
	 */
	public Stock getItemInfoByCode(String itemCode);
	/**
	 * 품목정보 상세조회: 재고 통합
	 * @param itemCode
	 * @return 품목 하나 재고 여럿 통합정보
	 */
	public Stock getItemStockByCode(String itemCode);
}
