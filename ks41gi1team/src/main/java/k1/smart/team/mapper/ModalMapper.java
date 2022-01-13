package k1.smart.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.MaterialOrder;

@Mapper
public interface ModalMapper {
	public List<MaterialOrder> getMaterialOrderList();
}
