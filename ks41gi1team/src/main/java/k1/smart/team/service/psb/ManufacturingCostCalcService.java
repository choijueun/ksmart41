package k1.smart.team.service.psb;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.psb.ManufacturingCostCalc;
import k1.smart.team.mapper.psb.ManufacturingCostCalcMapper;

@Service
public class ManufacturingCostCalcService {
	private ManufacturingCostCalcMapper manufacturingCostCalcMapper;
	private List<ManufacturingCostCalc> manufacturingCostCalcList;
	
	public ManufacturingCostCalcService(ManufacturingCostCalcMapper manufacturingCostCalcMapper) {
		this.manufacturingCostCalcMapper = manufacturingCostCalcMapper;
	}
		
	
	//전체 비용 검색
			public List<ManufacturingCostCalc> getManufacturingCostCalcList(){
				List<ManufacturingCostCalc> manufacturingCostCalcList= manufacturingCostCalcMapper.getManufacturingCostCalcList();
		
				if(CommonUtils.isEmpty(manufacturingCostCalcList)) {
					
					System.out.println("manufacturingCostCalcList"+ manufacturingCostCalcList +"서비스 null이다.");
					// 널(null)이거나 공백(빈칸)일 경우 실행
					
				} else {
					System.out.println("manufacturingCostCalcList"+ manufacturingCostCalcList +"서비스 null이 아니다.");
					// 널(null)이 아니거나 공백(빈칸)이 아닐때 실행
					
				}
				return manufacturingCostCalcList;
			}
}
