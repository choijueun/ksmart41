package k1.smart.team.service.psb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.mapper.csh.ClientMapper;
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
	
	public List<Contract> getContractList(){
		List<Contract> contractList = contractMapper.getContractList();
		
		return contractList;
	}

	//검색 하나의 목록 조회(검색)
		public List<Contract> getContractListBySearchKey(String searchKey, String searchValue){
			return contractMapper.getContractListBySearchKey(searchKey, searchValue);
		}

	//계약서 페이지 	수 보여주기
		public Map<String, Object> getContractHistory(int currentPage){
			
			// /loginHistory1?currentPage=1  , default 값을 1로 고정시켜서  앞에 말한게 안나와도 1에 해당되는 화면출력
			
			// 보여줄 행의 갯수
			int rowPerPage = 5;
			
			// 로그인 이력 테이블 행의 갯수
			double rowCount = contractMapper.getContractHistoryCount();
			
			// 라스트 페이지
			int lastPage = (int)Math.ceil(rowCount / rowPerPage);
			
			// 페이지 알고리즘
			int startNum = 0;
			
			// 보여줄 시작 페이지 번호
			int startPageNum = 1;
			// 보여줄 마지막 페이지 번호
			int endPageNum = 10;
			//동적 페이지 구성( 7페이지 부터 )
			if(currentPage > 6) {
				startPageNum = currentPage -5;
				endPageNum = currentPage + 4;
				if(endPageNum >= lastPage ) {
					startPageNum = lastPage -9;
					endPageNum = lastPage;
				}
			}
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("startNum", startNum);
			paramMap.put("rowPerPage", rowPerPage);
			
			List<Map<String, Object>> contractHistoryList = contractMapper.getContractHistoryList(paramMap);
			
			paramMap.clear();
			paramMap.put("lastPage", lastPage);
			paramMap.put("contractHistoryList", contractHistoryList);
			paramMap.put("startPageNum", startPageNum);
			paramMap.put("endPageNum", endPageNum);
			
			return paramMap;
		}
		
		
		
	//계약서 전체조회 이력 조회
		public List<Map<String, Object>> getContractHistory() {
			
			return contractMapper.getContractHistoryList(null);
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

		public String getContractInfo() {
			
			return contractMapper.getContractInfo();
		}

	
}