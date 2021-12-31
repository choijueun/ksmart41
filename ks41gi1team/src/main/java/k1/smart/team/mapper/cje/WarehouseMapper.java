package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Warehouse;

@Mapper
public interface WarehouseMapper {
	/**
	 * 창고정보 전체조회
	 * @param mainBusinessCode
	 * @return 창고 여러개 정보
	 */
	public List<Warehouse> getAllWarehouseList(String mainBusinessCode);
}
