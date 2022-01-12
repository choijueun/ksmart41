package k1.smart.team.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeMapper {
	//특정 테이블의 PRIMARY KEY
	public String getPrimaryKey(String tableName);
	
	//기본키 숫자부분 새로 형성(마지막 값 +1)
	public String getNewCodeNum(String tableName, String columnName);
}
