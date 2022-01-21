package k1.smart.team.mapper.csh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Client;

@Mapper
public interface ClientMapper {
	//거래처정보 전체조회
	public List<Client> getAllClientList(String mainBusinessCode);

	//거래처 전체목록에서 검색
	public List<Client> getClientListBySearchKey(String searchKey, String searchValue);

	//거래처 상세
	public Client getClientDetail(String clientCode);

	//거래처 정보 수정
	public int modifyClient(Client client);

}
