package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.MaterialUseMapper;

@Service
public class MaterialUseService {
	private MaterialUseMapper materialUseMapper;
	public MaterialUseService(MaterialUseMapper materialUseMapper) {
		this.materialUseMapper = materialUseMapper;
	}

}
