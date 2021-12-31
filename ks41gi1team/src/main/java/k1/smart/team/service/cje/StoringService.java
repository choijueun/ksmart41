package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class StoringService {
	private StoringMapper storingMapper;
	private List<Storing> storingList; //물류 배열
	private Storing storingInfo; //물류
	
	/**
	 * 생성자 메서드
	 * @param storingMapper
	 */
	public StoringService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	
	/**
	 * 물류 전체목록 조회
	 * @param mainBusinessCode
	 * @return List<Storing>
	 */
	public List<Storing> getAllStoringList(String mainBusinessCode) {
		storingList = storingMapper.getAllStoringList(mainBusinessCode);
		
		if(storingList == null) {
			System.out.println("재고조정내역 조회결과 없음");
			return null;
		}
		
		//코드 번호
		String storingNum;
		int stockReasonCode;
		for(int i=0; i<storingList.size(); i++) {
			storingInfo = storingList.get(i);
			//코드
			storingNum = storingInfo.getStockAdjCode();
			storingNum = storingNum.substring(storingNum.length()-3, storingNum.length());
			storingInfo.setStockAdjCode(storingNum);
			//사유
			stockReasonCode = storingInfo.getStockReasonCode();
			if(stockReasonCode == 1) storingInfo.setStockReason("입고");
			if(stockReasonCode == 2) storingInfo.setStockReason("자재사용");
			if(stockReasonCode == 3) storingInfo.setStockReason("생산");
			if(stockReasonCode == 4) storingInfo.setStockReason("창고이동");
			if(stockReasonCode == 5) storingInfo.setStockReason("출하");
			if(stockReasonCode == 6) storingInfo.setStockReason("재고차이");
			if(stockReasonCode == 7) storingInfo.setStockReason("반품");
			if(stockReasonCode == 8) storingInfo.setStockReason("불량");
		}
		return storingList;
	}

}
