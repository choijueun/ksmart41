package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class StoringService {
	private StoringMapper storingMapper;
	public StoringService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}

}
