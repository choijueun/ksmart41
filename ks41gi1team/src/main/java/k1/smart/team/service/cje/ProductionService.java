package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.ProductionMapper;

@Service
public class ProductionService {
	private ProductionMapper productionMapper;
	public ProductionService(ProductionMapper productionMapper) {
		this.productionMapper = productionMapper;
	}
}
