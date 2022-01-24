package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.pjh.Cost;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.ContractMapper;

@Service
@Transactional(readOnly = false)
public class ContractService {
	private ContractMapper contractMapper;
	private List<Contract> contractList;
	private List<Contract> contractHistoryList;
	private List<Contract> contractCodeForMaterialOrderCodeList;
	private Contract contractInfo;
	
	@Autowired
	private CodeMapper codeMapper;
	
	//생성자메서드 주입방식	
	public ContractService(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	//계약서 등록
	public int addContract(Contract contract) {
		System.out.println(contract.toString());
		int result = contractMapper.addContract(contract);
		
		return result;
	}
	
	public List<Contract> getContractList(){
		List<Contract> contractList = contractMapper.getContractList();
		
		return contractList;
	}

	//검색 하나의 목록 조회(검색)
		public List<Contract> getContractListBySearchKey(String searchKey, String searchValue){
			return contractMapper.getContractListBySearchKey(searchKey, searchValue);
		}

	//계약서 상세
		public Contract getContractInfoByCode(String contractCode) {
			System.out.println("contractCode--->" + contractCode);
			contractInfo = contractMapper.getContractInfoByCode("contractCode_"+contractCode);
			System.out.println("contractCode--->" + contractCode);
			
			if(contractInfo == null) {
				System.out.println("계약정보 조회결과 없음");
				return null;
			}
			contractInfo.setContractCode(contractCode);
			return contractInfo;
		}
		
		
		//발주서 등록을 위한 발주 계약서 코드만 따로 불러오기
		public List<Contract> getContractCodeForMaterialOrderCodeList() {
			contractCodeForMaterialOrderCodeList = contractMapper.getContractCodeForMaterialOrderCodeList();
			
			System.out.println("contractCodeForMaterialOrderCodeList--->" + contractCodeForMaterialOrderCodeList);
			
			return contractCodeForMaterialOrderCodeList;
		}
		
	//계약서 전체조회 이력 조회
		public List<Contract> getContractHistoryList(String mainBusinessCode) {
			contractList = contractMapper.getContractHistoryList(mainBusinessCode);
			 System.out.println("service contractList: " + contractList);
			 
			 if(contractList == null) {
					System.out.println("계약리스트 조회결과 없음");
					return null;
				}
			 
		
			 String contractNum; 
				for(int i=0; i<contractList.size(); i++) { 
				contractInfo = contractList.get(i);
				contractNum = contractInfo.getContractCode();
				contractNum = contractNum.substring(contractNum.length()-3, contractNum.length());
				contractList.get(i).setContractCode(contractNum); }
			 
			 
			return contractList;
		} 
		
	//전체 계약 검색
		public List<Contract> getAllContractList(){
			contractList = contractMapper.getAllContractList(null);
			
			String contractNum;
			for(int i=0; i<contractList.size(); i++) {
				contractNum = contractList.get(i).getContractCode().replace("contractCode_", "");
				contractList.get(i).setContractCode(contractNum);
			}
			System.out.println("contractList: " + contractList  );
			return contractList;
		}
		
	//계약서 여부 체크	
		public int getContractByContractCode(String contractCode) {
			int result = 0;
			result += contractMapper.getContractByContractCode(contractCode);
			return result;
		}

		public String getContractCode() {
			
			return contractMapper.getContractCode();
		}

		//계약서 수정
		public int modifyContract(Contract contract) {
			return contractMapper.modifyContract(contract);
		}




	
}