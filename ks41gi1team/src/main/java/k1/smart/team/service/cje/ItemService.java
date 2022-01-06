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
}
