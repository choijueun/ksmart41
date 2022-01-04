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
		storingList = storingMapper.getAllStoringList(mainBusinessCode, null);
		
		if(storingList == null) {
			System.out.println("재고조정내역 조회결과 없음");
			return null;
		}
		
		//물류이동 사유
		int stockReasonCode;
		for(int i=0; i<storingList.size(); i++) {
			storingInfo = storingList.get(i);
			stockReasonCode = storingInfo.getStockReasonCode();
			if(stockReasonCode == 1) {
				storingInfo.setStockReason("입고");
				storingInfo.setStockReasonEng("Warehousing");
			}
			else if(stockReasonCode == 2) {
				storingInfo.setStockReason("자재사용");
				storingInfo.setStockReasonEng("MaterialUse");
			}
			else if(stockReasonCode == 3) {
				storingInfo.setStockReason("생산");
				storingInfo.setStockReasonEng("Production");
			}
			else if(stockReasonCode == 4) {
				storingInfo.setStockReason("창고이동");
				storingInfo.setStockReasonEng("Moving");
			}
			else if(stockReasonCode == 5) {
				storingInfo.setStockReason("출하");
				storingInfo.setStockReasonEng("Shipment");
			}
			else if(stockReasonCode == 6) {
				storingInfo.setStockReason("재고차이");
				storingInfo.setStockReasonEng("Adjustment");
			}
			else if(stockReasonCode == 7) {
				storingInfo.setStockReason("반품");
				storingInfo.setStockReasonEng("Return");
			}
			else if(stockReasonCode == 8) {
				storingInfo.setStockReason("불량");
				storingInfo.setStockReasonEng("Defect");
			}
		}
		return storingList;
	}

}
