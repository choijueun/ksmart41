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

	/**
	 * 품목 전체목록 조회
	 * @param mainBusinessCode
	 * @return 품목 여러개 정보
	 */
	public List<Stock> getAllItemList(String mainBusinessCode){
		//전체목록
		itemList = itemMapper.getAllItemList(mainBusinessCode);
		if(itemList == null) {
			System.out.println("품목정보 조회결과 없음");
		}
		
		return itemList;
	}
	
	/**
	 * 품목 상세정보 조회
	 * @param itemCode
	 * @return 품목 하나 정보
	 */
	public Stock getItemInfoByCode(String itemCode) {
		itemInfo = itemMapper.getItemInfoByCode("itemCode_"+itemCode); //품목정보
		item1StockInfo = itemMapper.getItemStockByCode("itemCode_"+itemCode); //품목총재고정보
		
		//품목코드 존재 확인
		if(itemInfo == null) {
			System.out.println("품목정보 조회결과 없음 - 품목코드 ERROR");
			return null;
		}
		//품목총재고정보 입력
		if(item1StockInfo != null ) {
			itemInfo.setItemCount(item1StockInfo.getItemCount());
			itemInfo.setProductPrice(item1StockInfo.getProductPrice());
			itemInfo.setTotalPrice(item1StockInfo.getTotalPrice());
			itemInfo.setStockWeight(item1StockInfo.getStockWeight());
		}
		
		return itemInfo;
	}
}
