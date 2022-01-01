package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class ReturnService {
	private StoringMapper storingMapper;
	public ReturnService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}

}
