package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.cje.ItemMapper;

@Service
public class ItemService {
	private ItemMapper itemMapper;
	private List<Stock> itemList;
	private Stock itemInfo;
	private List<Stock> stockList;
	private Map<String, Object> resultMap = new HashMap<String, Object>();

	/**
	 * 생성자 메서드
	 * 
	 * @param itemMapper
	 */
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	/**
	 * 품목 전체목록 조회
	 * 
	 * @param mainBusinessCode
	 * @return 품목 여러개 정보
	 */
	public List<Stock> getAllItemList(String mainBusinessCode) {
		// 전체목록
		itemList = itemMapper.getAllItemList(mainBusinessCode);

		return itemList;
	}

	/**
	 * 품목 상세정보 조회
	 * 
	 * @param itemCode
	 * @return 품목 하나 정보
	 */
	public Map<String, Object> getItemInfo(String itemCode) {
		itemInfo = itemMapper.getItemInfo(itemCode); // 품목정보
		if (itemInfo == null)
			return null;
		stockList = itemMapper.getItemStock(itemCode); // 품목재고현황

		resultMap.clear();
		resultMap.put("itemInfo", itemInfo);
		resultMap.put("stockList", stockList);

		return resultMap;
	}

	public Map<String, Object> getItemCategory(String largeCategory, String middleCategory, String smallCategory) {
		resultMap.clear();
		resultMap.put("largeCategory", itemMapper.getCategoryLarge());
		if(largeCategory != null && !"".equals(largeCategory)) {
			resultMap.put("middleCategory", itemMapper.getCategoryMiddle(largeCategory));
			if(middleCategory != null && !"".equals(middleCategory)) {
				resultMap.put("smallCategory", itemMapper.getCategorySmall(largeCategory,middleCategory)); 
				if(smallCategory != null && !"".equals(middleCategory)) {
					resultMap.put("microCategory", itemMapper.getCategoryMicro(largeCategory,middleCategory, smallCategory)); 
				}
			} 
		}

		return resultMap;
	}

	public boolean itemNameValid(String mainBusinessCode, String itemName) {
		if (itemName == null || "".equals(itemName))
			return false;
		if (itemMapper.itemNameValid(mainBusinessCode, itemName) > 0)
			return true;
		return false;
	}

	/**
	 * 품목정보 등록 process
	 * 
	 * @param itemInfo
	 * @return
	 */
	public boolean addItem(Stock itemInfo) {
		// 카테고리 코드 반환
		List<String> categoryCodes = itemMapper.getCategoryCode(itemInfo.getLargeCategory(),
				itemInfo.getMiddleCategory(), itemInfo.getSmallCategory(), itemInfo.getMicroCategory());
		if (categoryCodes != null && categoryCodes.size() == 1) {
			itemInfo.setCategoryCode(categoryCodes.get(0));
		}

		// 등록 처리
		if (itemMapper.addItem(itemInfo) == 1)
			return true;

		return false;
	}
}
