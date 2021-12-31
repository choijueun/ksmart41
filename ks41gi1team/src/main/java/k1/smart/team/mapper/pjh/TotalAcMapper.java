package k1.smart.team.mapper.pjh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.pjh.TotalAc;

@Mapper
public interface TotalAcMapper {
	public List<TotalAc> getTotalAcList(String mainBusinessCode);
	
	public List<TotalAc> getTotalAcInfo(String mainBusinessCode);
	
}
