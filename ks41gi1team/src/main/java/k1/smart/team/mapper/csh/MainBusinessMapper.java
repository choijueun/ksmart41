package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.MainBusiness;
@Mapper
public interface MainBusinessMapper {

	List<MainBusiness> getAllMainBusinessList(String mainBusinessCode);

}
