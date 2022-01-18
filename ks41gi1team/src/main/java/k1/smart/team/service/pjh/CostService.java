package k1.smart.team.service.pjh;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.Cost;
import k1.smart.team.mapper.pjh.CostMapper;

@Service
public class CostService {
	private CostMapper costMapper;
	private List<Cost> costList; //재고 여러개
	private Cost costInfo; //재고 상세
	
	//생성자메서드
	public CostService(CostMapper costMapper) {
		this.costMapper = costMapper;
	}
	
	public List<Cost> getAllCostList(String mainBusinessCode) {
		costList = costMapper.getAllCostList(mainBusinessCode);
		if(costList == null) {
			System.out.println("기타비용 조회결과 없음");
			return null;
		}
		
		
		String costNum; 
		for(int i=0; i<costList.size(); i++) { 
		costInfo = costList.get(i);
		costNum = costInfo.getEtcPurchaseCode();
		costNum = costNum.substring(costNum.length()-3, costNum.length());
		costList.get(i).setEtcPurchaseCode(costNum); }
		
		
		return costList;
	}
	
	public Cost getCostInfoByCode(String etcPurchaseCode) {
		costInfo = costMapper.getCostInfoByCode("etcPurchaseCode_"+etcPurchaseCode);
		
		if(costInfo == null) {
			System.out.println("비용정보 조회결과 없음");
			return null;
		}
		costInfo.setEtcPurchaseCode(etcPurchaseCode);
		return costInfo;
	}
	
	public Cost getCostInfo (String etcPurchaseCode) {
		Cost getCostInfo = costMapper.getCostInfoByCode(etcPurchaseCode);
		return getCostInfo;
	}
	
	//기타비용 등록
	public int addCost(Cost cost) {
		int addCost = costMapper.addCost(cost);
		return addCost;
	}
	
	//기타비용 등록시 코드 세팅
	public String getAddCostCode() {
		
		return costMapper.getAddCostCode();
	}
	
	//기타비용 수정
	public void costModify(Cost cost) {
		costMapper.costModify(cost);
	}
	
	
}














