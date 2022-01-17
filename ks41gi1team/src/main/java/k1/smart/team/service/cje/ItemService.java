package k1.smart.team.service.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.cje.ItemMapper;

@Service
@Transactional
public class ItemService {
	private ItemMapper itemMapper;
	private List<Stock> itemList;
	private Stock itemInfo;
	private List<Stock> stockList;

	/**
	 * 생성자 메서드
	 * @param itemMapper
	 */
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	/**
	 * 품목 전체목록 조회
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
	 * @param itemCode
	 * @return 품목 하나 정보
	 */
	public Map<String, Object> getItemInfo(String itemCode) {
		//품목정보 조회
		itemInfo = itemMapper.getItemInfo(itemCode);
		if (CommonUtils.isEmpty(itemInfo)) return null;
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("itemInfo", itemInfo);
		
		//해당 품목의 창고별 재고현황 조회
		stockList = itemMapper.getItemStock(itemCode);
		resultMap.put("stockList", stockList);

		return resultMap;
	}

	/**
	 * 품목 카테고리 조회
	 * @param largeCategory
	 * @param middleCategory
	 * @param smallCategory
	 * @return largeCategory, middleCategory, smallCategory, microCategory
	 */
	public Map<String, Object> getItemCategory(String largeCategory, String middleCategory, String smallCategory) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//대분류 전체조회
		resultMap.put("largeCategory", itemMapper.getCategoryLarge());
		//선택된 대분류의 하위 중분류 전체조회
		resultMap.put("middleCategory", itemMapper.getCategoryMiddle(largeCategory));
		//선택된 중분류의 하위 소분류 전체조회
		resultMap.put("smallCategory", itemMapper.getCategorySmall(largeCategory,middleCategory)); 
		if(smallCategory != null && !"".equals(middleCategory)) {
			//선택된 소분류의 하위 소소분류 전체조회
			resultMap.put("microCategory", itemMapper.getCategoryMicro(largeCategory,middleCategory, smallCategory)); 
		}

		return resultMap;
	}
	
	/**
	 * 품목명 중복검사
	 * @param mainBusinessCode
	 * @param itemName
	 * @return 중복 true 중복아님 false
	 */
	public boolean itemNameValid(String mainBusinessCode, String itemName) {
		if (CommonUtils.isEmpty(itemName)) {
			//itemName NULL or 공백
			return false;
		} else if (itemMapper.itemNameValid(mainBusinessCode, itemName) > 0) {
			//동일한 품목명 존재
			return true;
		}
		return false;
	}

	/**
	 * 품목정보 등록 process
	 * @param itemInfo
	 * @return 등록성공 true 실패 false
	 */
	public boolean addItem(Stock itemInfo) {
		//카테고리 코드 반환
		List<String> categoryCodes = itemMapper.getCategoryCode(
				itemInfo.getLargeCategory(),itemInfo.getMiddleCategory(), itemInfo.getSmallCategory(), itemInfo.getMicroCategory());
		//카테고리코드 정상조회
		if (!CommonUtils.isEmpty(categoryCodes) && categoryCodes.size() == 1) {
			itemInfo.setCategoryCode(categoryCodes.get(0));
		}

		// 등록 처리
		if (itemMapper.addItem(itemInfo) == 1) return true;

		return false;
	}
}
