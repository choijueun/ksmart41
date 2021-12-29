package k1.smart.team.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeMapper {
	public String selectCodeNum(String codeName, String tableName);
	
	public String getNewCodeNum(String codeName, String tableName);
}
