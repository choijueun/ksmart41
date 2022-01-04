package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ShipmentService {
	private StoringMapper storingMapper;
	public ShipmentService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}

}
