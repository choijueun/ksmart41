package k1.smart.team.service.cje;

import java.util.ArrayList;
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
	
	public List<Stock> getAllCategories(String mainBusinessCode) {
		return itemMapper.getAllCategories(mainBusinessCode);
	}

	/**
	 * 특정 카테고리 목록 조회
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
	 * 카테고리 코드 반환
	 * @param categories
	 */
	public String getItemCategoryCode(List<String> categories) {
		//공백 null로 변경
		if(CommonUtils.isEmpty(categories.get(2))) categories.set(2, null);
		if(CommonUtils.isEmpty(categories.get(3))) categories.set(3, null);
		//카테고리 코드 검색
		List<String> categoryCodes = itemMapper.getCategoryCode(categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));
		//NULL체크 & 개수 검사
		if (!CommonUtils.isEmpty(categoryCodes) && categoryCodes.size() == 1) {
			return categoryCodes.get(0);
		}
		return null;
	}

	/**
	 * 품목정보 등록 process
	 * @param itemInfo
	 * @return 등록성공 true 실패 false
	 */
	public boolean addItem(Stock itemInfo) {
		//System.out.println("1. 제품인데 카테고리 코드가 없다.");
		if("제품".equals(itemInfo.getItemType()) && CommonUtils.isEmpty(itemInfo.getCategoryCode())) {
			//공백 NULL 치환
			if(CommonUtils.isEmpty(itemInfo.getSmallCategory())) itemInfo.setSmallCategory(null);
			if(CommonUtils.isEmpty(itemInfo.getMicroCategory())) itemInfo.setMicroCategory(null);
			//System.out.println("2. 카테고리 정보를 등록했다.");
			if(itemMapper.addItemCategory(itemInfo) > 0) {
				//System.out.println("3. 등록한 카테고리 코드를 조회한다.");
				List<String> categories = new ArrayList<String>();
				categories.add(itemInfo.getLargeCategory());
				categories.add(itemInfo.getMiddleCategory());
				categories.add(itemInfo.getSmallCategory());
				categories.add(itemInfo.getMicroCategory());
				categories.add(itemInfo.getMainBusinessCode());
				
				String categoryCode = this.getItemCategoryCode(categories);
				
				//System.out.println("4. 카테고리 코드를 품목정보에 추가한다.");
				itemInfo.setCategoryCode(categoryCode);
			}
			if( CommonUtils.isEmpty(itemInfo.getCategoryCode()) ) return false;
		}

		// 등록 처리
		if (itemMapper.addItem(itemInfo) == 1) return true;

		return false;
	}
	
	/**
	 * 카테고리 정보 등록 절차
	 * @param mainBusinessCode
	 * @param stock
	 */
	public void addItemCategory(Stock stock) {
		itemMapper.addItemCategory(stock);
	}

	/**
	 * 카테고리 정보 수정 절차
	 * @param stock
	 */
	public void modifyItemCategory(Stock stock) {
		itemMapper.modifyItemCategory(stock);
	}
}
