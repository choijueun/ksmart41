package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.psb.Contract;

@Mapper
public interface ContractMapper {

	//계약서 중복 체크
	public int getContractByContractCode(String contractCode);
	
	//계약서 등록
	public int addContract(Contract contract);
	
	public List<Client> getClientList();

	
	//계약서 하나의 화면 조회
	public List<Contract> getContractListBySearchKey(String searchKey, String searchValue);
	
	//계약서 전체 조회
		public List<Contract> getAllContractList(String mainBusinessCode);


}
