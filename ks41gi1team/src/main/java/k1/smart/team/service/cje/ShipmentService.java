package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.ShipmentMapper;

@Service
public class ShipmentService {
	private ShipmentMapper shipmentMapper;
	public ShipmentService(ShipmentMapper shipmentMapper) {
		this.shipmentMapper = shipmentMapper;
	}

}
