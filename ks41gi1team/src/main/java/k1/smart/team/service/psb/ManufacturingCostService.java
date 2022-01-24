package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.psb.ManufacturingCost;
import k1.smart.team.mapper.CodeMapper;
import k1.smart.team.mapper.psb.ManufacturingCostMapper;

@Service
public class ManufacturingCostService {
	private ManufacturingCostMapper manufacturingCostMapper;
	private List<ManufacturingCost> manufacturingCostList;
	
	@Autowired
	private CodeMapper codeMapper;
	
	public ManufacturingCostService(ManufacturingCostMapper manufacturingCostMapper) {
		this.manufacturingCostMapper = manufacturingCostMapper;
	}
		
	
	//전체 비용 검색
			public List<ManufacturingCost> getManufacturingCostList(){
				List<ManufacturingCost> manufacturingCostList= manufacturingCostMapper.getManufacturingCostList();
		
				if(CommonUtils.isEmpty(manufacturingCostList)) {
					
					System.out.println("manufacturingCostList"+ manufacturingCostList +"서비스 null이다.");
					// 널(null)이거나 공백(빈칸)일 경우 실행
					
				} else {
					System.out.println("manufacturingCostList"+ manufacturingCostList +"서비스 null이 아니다.");
					// 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
					
				}
				return manufacturingCostList;
			}
}
