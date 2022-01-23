package k1.smart.team.mapper.psb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.psb.Contract;

@Mapper
public interface ContractMapper {

	//계약서 중복 체크
	public int getContractByContractCode(String contractCode);
	
	//계약서 등록
	public int addContract(Contract contract);
	
	public List<Contract> getContractList();

	
	//계약서 하나의 화면 조회
	public List<Contract> getContractListBySearchKey(String searchKey, String searchValue);
	
	//계약서 전체 조회
		public List<Contract> getAllContractList(String mainBusinessCode);

	//계약서 전체 이력 조회	
		public List<Contract> getContractHistoryList(String mainBusinessCode);

	//계약서 이력 테이블 튜플의 총 갯수	
		public int getContractHistoryCount();

		//계약서 이름 가져오기
		public String getContractInfo();

	// 계약서 수정
		public int modifyContract(Contract contract);

	//발주서 등록을 위한 발주만을 위한 계약서 코드	
	/* public List<Contract> getContractCodeForMaterialOrderCode(); */

		public List<Contract> getContractCodeForMaterialOrderCodeList();


}
