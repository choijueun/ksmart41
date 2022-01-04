package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.MaterialOrder;

@Mapper
public interface MaterialOrderMapper {

	
	//하나의 발주 조회
	public List<MaterialOrder> getMaterialOrderListBySearchKey(String searchKey, String searchValue);
		
	//발주 전체 조회
	public List<MaterialOrder> getAllMaterialOrderList(String mainBusinessCode);

}
