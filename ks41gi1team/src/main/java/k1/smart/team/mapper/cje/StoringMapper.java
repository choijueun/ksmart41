package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StoringMapper {
	//물류이동내역 전체조회
	public List<Storing> getAllStoringList(String mainBusinessCode, String stockReasonCode);
	//물류이동내역 상세조회
	public Storing getStoringInfo(String mainBusinessCode, String stockAdjCode, String stockReasonCode);
	
	//6. 재고차이조정 상세내역 배열
	public List<Storing> getAdjDetails(String stockAdjCode);
	
	//7. 반품처리 상세내역 배열
	public List<Storing> getReturnDetails(String stockAdjCode);
	
	//8. 불량처리 상세내역 배열
	public List<Storing> getDefectDetails(String stockAdjCode);
}
