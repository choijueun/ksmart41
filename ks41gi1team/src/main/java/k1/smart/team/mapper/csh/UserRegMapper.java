package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.UserReg;

@Mapper
public interface UserRegMapper {
	
	//회원가입 요청 전체조회
	List<UserReg> getAllUserRegList(String mainBusinessCode);

}
