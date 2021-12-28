package k1.smart.team.service;

import java.util.List;

import k1.smart.team.dto.Contract;
import k1.smart.team.mapper.ContractMapper;







public class ContractService {
	//생성자메서드 주입방식
	private ContractMapper contractMapper;
	public ContractService(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	//화면목록조회(검색)
	
		public List<Contract> getContractListBySearchKey(String searchKey, String searchValue){
			return contractMapper.getContractListBySearchKey(searchKey, searchValue);
		}
		
}