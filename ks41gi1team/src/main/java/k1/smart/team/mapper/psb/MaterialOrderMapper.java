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
	public List<MaterialOrderInfo> getMaterialOrderInfoList(String materialOrderCode);
	
	//하나의 발주 조회
	public List<MaterialOrder> getMaterialOrderListBySearchKey(String searchKey, String searchValue);
		
	//발주 전체 조회
	public List<MaterialOrder> getAllMaterialOrderList(String mainBusinessCode);

	//발주 수정 조회
	public int modifyMaterilOrderInfo(MaterialOrder materialOrder);
	
	//발주 정보 조회
	public MaterialOrder getMaterialOrderInfoByMaterialOrderCode(String materialOrderCode);




	


}
