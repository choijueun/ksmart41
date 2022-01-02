package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class AdjustmentService {
	private StoringMapper storingMapper;;
	private List<Storing> adjList; //재고조정내역 배열
	private Storing adjInfo; //재고조정내역 상세정보
	/**
	 * 생성자 메서드
	 * @param adjMapper
	 */
	public AdjustmentService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	/**
	 * 재고조정내역 전체조회
	 * @param mainBusinessCode
	 * @return 재고조저내역 여러개(List<Storing>)
	 */
	public List<Storing> getAllAdjList(String mainBusinessCode) {
		//재고조정내역 전체목록
		adjList = storingMapper.getAllStoringList(mainBusinessCode, "6");
		if(adjList != null) {
			String storingNum;
			for(int i=0; i<adjList.size(); i++) {
				adjInfo = adjList.get(i);
				//코드
				storingNum = adjInfo.getStockAdjCode();
				storingNum = storingNum.substring(storingNum.length()-3, storingNum.length());
				adjInfo.setStockAdjCode(storingNum);
			}
		}else {
			System.out.println("재고조정내역 조회결과 없음");
		}
		return adjList;
	}
	
	public Storing getAdjInfo(String stockAdjCode) {
		//재고조정내역 한줄정보
		adjInfo = storingMapper.getAdjInfo(stockAdjCode);
		if(adjInfo != null) {
			String num;
			//재고조정내역코드
			num = adjInfo.getStockAdjCode();
			num = num.substring(num.length()-3, num.length());
			adjInfo.setStockAdjCode(num);
			//나머지코드도...
		}else {
			System.out.println("재고조정내역 조회결과 없음");
		}
		return adjInfo;
	}
}
