package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.mapper.psb.ContractMapper;

@Service
public class ContractService {
	private ContractMapper contractMapper;
	private List<Contract> contractList;
	
	//생성자메서드 주입방식	
	public ContractService(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	//계약서 등록
	public int addContract(Contract contract) {
		
		int result = contractMapper.addContract(contract);
		
		return result;
	}
	
	//검색 하나의 목록 조회(검색)
		public List<Contract> getContractListBySearchKey(String searchKey, String searchValue){
			return contractMapper.getContractListBySearchKey(searchKey, searchValue);
		}

		public List<Contract> getContractList() {
			
			return null;
		}
	//전체 계약 검색
		public List<Contract> getAllContractList(String mainBusinessCode){
			contractList = contractMapper.getAllContractList(mainBusinessCode);
			
			String contractNum;
			for(int i=0; i<contractList.size(); i++) {
				contractNum = contractList.get(i).getContractCode().replace("contractCode", "");
				contractList.get(i).setContractCode(contractNum);
			}
			return contractList;
		}
		
	//계약서 여부 체크	
		public int getContractByContractCode(String contractCode) {
			int result = 0;
			result += contractMapper.getContractByContractCode(contractCode);
			return result;
		}
}