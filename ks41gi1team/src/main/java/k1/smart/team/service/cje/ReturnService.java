package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.ReturnMapper;

@Service
public class ReturnService {
	private ReturnMapper returnMapper;
	public ReturnService(ReturnMapper returnMapper) {
		this.returnMapper = returnMapper;
	}

}
