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
	 * @return 재고조정내역 여러개(List<Storing>)
	 */
	public List<Storing> getAllAdjList(String mainBusinessCode) {
		adjList = storingMapper.getAllStoringList(mainBusinessCode, "6");
		
		if(adjList == null) return null;
		
		return adjList;
	}
	
	/**
	 * 재고조정내역 한줄정보
	 * @param stockAdjCode
	 * @return
	 */
	public Storing getAdjInfo(String stockAdjCode) {
		adjInfo = storingMapper.getAdjInfo(stockAdjCode);
		return adjInfo;
	}
	/**
	 * 재고조정내역 상세정보 배열
	 * @param stockAdjCode
	 * @return
	 */
	public List<Storing> getAdjDetailInfo(String stockAdjCode) {
		adjList = storingMapper.getAdjDetailInfo(stockAdjCode);
		return adjList;
	}
}
