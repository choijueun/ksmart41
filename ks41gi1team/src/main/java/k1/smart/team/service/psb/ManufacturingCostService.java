package k1.smart.team.service.psb;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.psb.ManufacturingCostMapper;

@Service
public class ManufacturingCostService {
	private ManufacturingCostMapper manufacturingCostMapper;
	
	public ManufacturingCostService(ManufacturingCostMapper manufacturingCostMapper) {
		this.manufacturingCostMapper = manufacturingCostMapper;
	}
	
	public String getManufacturingCost() {
		return manufacturingCostMapper.getManufacturingCost();
	}
}
