package k1.smart.team.service.psb;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.psb.ManufacturingCostCalMapper;

@Service
public class ManufacturingCostCalService {
	private ManufacturingCostCalMapper manufacturingCostCalMapper;
	public ManufacturingCostCalService(ManufacturingCostCalMapper manufacturingCostCalMapper) {
		this.manufacturingCostCalMapper = manufacturingCostCalMapper;
	}
}
