package k1.smart.team.mapper;

import java.util.List;

import k1.smart.team.dto.Contract;
public interface ContractMapper {
	//계약서 화면 조회
	public List<Contract> getContractListBySearchKey(String searchKey, String searchValue);
	
	//계약서 전체 조회
		public List<Contract> getContractList();
}
