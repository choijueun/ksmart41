package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.mapper.cje.ItemMapper;

@Service
public class ItemService {
	private ItemMapper itemMapper;
	private List<Stock> itemList;
	private Stock itemInfo;
	private Stock item1StockInfo;
	
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	//품목 전체목록 조회
	public List<Stock> getAllItemList(String mainBusinessCode){
		itemList = itemMapper.getAllItemList(mainBusinessCode);
		String itemNum;
		for(int i=0; i<itemList.size(); i++) {
			itemInfo = itemList.get(i);
			itemNum = itemInfo.getItemCode().replace("itemCode_", "");
			itemInfo.setItemCode(itemNum);
		}
		return itemList;
	}
	
	public Stock getItemInfoByCode(String itemCode) {
		itemInfo = itemMapper.getItemInfoByCode(itemCode);
		item1StockInfo = itemMapper.getItemStockByCode(itemCode);
		
		
		return itemInfo;
	}
}
