package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class DefectService {
	private StoringMapper storingMapper;
	public DefectService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}

}
