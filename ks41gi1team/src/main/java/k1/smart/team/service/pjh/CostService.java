package k1.smart.team.service.pjh;

import java.util.List;

import k1.smart.team.dto.pjh.Cost;
import k1.smart.team.mapper.pjh.CostMapper;

public class CostService {
	private CostMapper costMapper;
	private List<Cost> costList;
	
	//생성자메서드
	public CostService(CostMapper costMapper) {
		this.costMapper = costMapper;
	}
	
	public List<Cost> getAllCostList(String mainBusinessCode) {
		costList = costMapper.getAllCostList(mainBusinessCode);
		
		String costNum;
		for(int i=0; i<costList.size(); i++) {
			costNum = costList.get(i).getEtcPurchaseCode().replace("etcPurchaseCode_", "");
			costList.get(i).setEtcPurchaseCode(costNum);
		}
		
		return costList;
	}

}
