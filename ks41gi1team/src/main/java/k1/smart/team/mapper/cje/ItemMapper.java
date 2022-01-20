package k1.smart.team.mapper.cje;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;

@Mapper
public interface ItemMapper {
	/**
	 * 품목정보 전체조회
	 * @param mainBusinessCode
	 * @return 품목 여러개 정보
	 */
	public List<Stock> getAllItemList(Map<String, Object> paramMap);
	
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
	
	/**
	 * 사업장의 모든 카테고리 목록 조회
	 * @param mainBusinessCode
	 */
	public List<Stock> getAllCategories(String mainBusinessCode);
	
	//카테고리 목록 조회
	public List<String> getCategoryLarge();
	public List<String> getCategoryMiddle(String largeCategory);
	public List<String> getCategorySmall(String largeCategory, String middleCategory);
	public List<String> getCategoryMicro(String largeCategory, String middleCategory, String smallCategory);
	
	//카테고리 코드 조회
	public List<String> getCategoryCode(String largeCategory, String middleCategory, String smallCategory, String microCategory, String mainBusinessCode);
	
	//품목명 중복 검사
	public int itemNameValid(String mainBusinessCode, String itemName);
	
	/**
	 * 품목정보 등록
	 * @param itemInfo
	 * @return 성공시 1 실패시 0
	 */
	public int addItem(Stock itemInfo);
	
	/**
	 * 품목정보 수정
	 * @param itemInfo
	 * @return 성공시 1 실패시 0
	 */
	public int modifyItem(Stock itemInfo);
	
	/**
	 * 카테고리 정보 등록
	 * @param mainBusinessCode
	 * @param stock
	 */
	public int addItemCategory(Stock stock);

	/**
	 * 카테고리 정보 수정
	 * @param stock
	 */
	public void modifyItemCategory(Stock stock);
}
