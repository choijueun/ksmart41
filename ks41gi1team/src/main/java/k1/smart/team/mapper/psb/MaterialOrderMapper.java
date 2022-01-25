package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;

@Mapper
public interface MaterialOrderMapper {

	//발주 정보 수정
	public int modifyMaterialOrderInfo(MaterialOrder materialOrder);
	
	/*
	 * //발주내역 상세조회(하나일경우) public MaterialOrderInfo getMaterialOrderInfo(String
	 * mainBusinessCode, String materialOrderCode);
	 */
	
	//발주내역 상세조회(여러개 일경우)
	public List<MaterialOrderInfo> getMaterialOrderInfoList(String mainBusinessCode, String materialOrderCode);
	
	//발주 상세
	public MaterialOrder getMaterialOrderInfo(String materialOrderCode);
	
	


	
	//발주 전체 조회
	public List<MaterialOrder> getMaterialOrderList(String mainBusinessCode);

	//발주 수정 조회
	public int modifyMaterilOrderInfo(MaterialOrder materialOrder);
	
	//발주 정보 조회
	public MaterialOrder getMaterialOrderInfoByMaterialOrderCode(String materialOrderCode);

	//발주 등록
	public int addMaterialOrder(MaterialOrder materialOrder);
		
	//발주 전체 이력 조회
	public List<MaterialOrder> getMaterialOrderList();

	//발주 코드 자동 추가 보여주기
	public String getMaterialOrderCode();

	//발주 중복 체크
	public int getMaterialOrderByMaterialOrderCode(String materialOrderCode);


}
