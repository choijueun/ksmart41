package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.ManufacturingCost;


@Mapper
public interface ManufacturingCostMapper {

	//비용 전체 조회
	public List<ManufacturingCost> getManufacturingCostList();


}
