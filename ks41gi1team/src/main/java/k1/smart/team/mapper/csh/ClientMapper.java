package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Client;

@Mapper
public interface ClientMapper {
	//거래처정보 전체조회
	public List<Client> getAllClientList(String mainBusinessCode);

}
