package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.DelivryMapper;

@Service
public class DelivryService {
	private DelivryMapper delivryMapper;
	public DelivryService(DelivryMapper delivryMapper) {
		this.delivryMapper = delivryMapper;
	}

}
