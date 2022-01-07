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
	public Stock getItemInfo(String itemCode);
	
	/**
	 * 품목정보 상세조회: 재고 통합
	 * @param itemCode
	 * @return 품목 하나 재고 여럿 통합정보
	 */
	public List<Stock> getItemStock(String itemCode);
	
	//카테고리 목록 조회
	public List<String> getCategoryLarge();
	public List<String> getCategoryMiddle(String largeCategory);
	public List<String> getCategorySmall(String largeCategory, String middleCategory);
	public List<String> getCategoryMicro(String largeCategory, String middleCategory, String smallCategory);
	
	//카테고리 코드 조회
	public List<String> getCategoryCode(String largeCategory, String middleCategory, String smallCategory, String microCategory);
	
	/**
	 * 품목정보 등록
	 * @param mainBusinessCode
	 * @param itemName
	 * @param itemType
	 * @param itemStandard
	 * @param itemOrigin
	 * @param itemCategory
	 * @param itemComment
	 * @return
	 */
	public int addItem(String mainBusinessCode, String itemName, String itemType, String itemStandard
			, String itemOrigin, String itemCategory, String itemComment);
}
