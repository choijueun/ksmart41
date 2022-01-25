package k1.smart.team.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeMapper {
	//특정 테이블의 PRIMARY KEY 조회
	public String getPrimaryKey(String tableName);
	
	//기본키 코드번호 새로 생성(마지막 값 +1)
	public String getNewCodeNum(String tableName, String columnName);
}
