package k1.smart.team.mapper.cje;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Storing;

@Mapper
public interface StoringMapper {

	List<Storing> getAllStoringList(String mainBusinessCode);

}
