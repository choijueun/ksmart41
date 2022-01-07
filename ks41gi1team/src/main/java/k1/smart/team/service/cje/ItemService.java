package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.cje.ItemMapper;

@Service
public class ItemService{
	private ItemMapper itemMapper;
	private List<Stock> itemList;
	private Stock itemInfo;
	private List<Stock> stockList;
	private Map<String,Object> resultMap = new HashMap<String,Object>();
	
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	/**
	 * 품목 전체목록 조회
	 * @param mainBusinessCode
	 * @return 품목 여러개 정보
	 */
	public List<Stock> getAllItemList(String mainBusinessCode){
		//전체목록
		itemList = itemMapper.getAllItemList(mainBusinessCode);
		
		return itemList;
	}
	
	/**
	 * 품목 상세정보 조회
	 * @param itemCode
	 * @return 품목 하나 정보
	 */
	public Map<String,Object> getItemInfo(String itemCode) {
		itemInfo = itemMapper.getItemInfo(itemCode); //품목정보
		if(itemInfo == null)  return null;
		stockList = itemMapper.getItemStock(itemCode); //품목재고현황
		
		resultMap.clear();
		resultMap.put("itemInfo", itemInfo);
		resultMap.put("stockList", stockList);
		
		return resultMap;
	}
	
	public Map<String,Object> getItemCategory(String largeCategory, String middleCategory, String smallCategory) {
		resultMap.clear();
		resultMap.put("largeCategory", itemMapper.getCategoryLarge());
		if(largeCategory != null) {
			resultMap.put("middleCategory", itemMapper.getCategoryMiddle(largeCategory));
			if(middleCategory != null) {
				resultMap.put("smallCategory", itemMapper.getCategorySmall(largeCategory, middleCategory));
				if(smallCategory != null) {
					resultMap.put("microCategory", itemMapper.getCategoryMicro(largeCategory, middleCategory, smallCategory));
				}
			}
		}
		return resultMap;
	}

	/**
	 * 품목정보 등록 process
	 * @param itemName
	 * @param itemType
	 * @param itemStandard
	 * @param itemOrigin
	 * @param itemCategory
	 * @param itemComment
	 * @param itemComment2 
	 * @param microCategory 
	 * @param smallCategory 
	 * @return
	 */
	public int addItem(String mainBusinessCode, String itemName, String itemType, String itemStandard, String itemOrigin
			, String largeCategory, String middleCategory, String smallCategory, String microCategory, String itemComment) {
		//카테고리 코드 반환
		List<String> categoryNames = itemMapper.getCategoryCode(largeCategory, middleCategory, smallCategory, microCategory);
		String itemCategory = null;
		if(categoryNames == null || categoryNames.size() > 1) {
			System.out.println("카테고리 코드를 찾을 수 없습니다.");
			return 0;
		} else if (categoryNames.size() == 1) {
			itemCategory = categoryNames.get(0);
		}
		//등록 처리
		int result = itemMapper.addItem(mainBusinessCode, itemName, itemType, itemStandard, itemOrigin, itemCategory, itemComment);
		
		return result;
	}
}
