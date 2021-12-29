package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.WarehouseMapper;

@Service
public class WarehouseService {
	private WarehouseMapper warehouseMapper;
	public WarehouseService(WarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}

}
