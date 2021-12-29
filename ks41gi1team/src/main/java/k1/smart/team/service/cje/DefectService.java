package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.DefectMapper;

@Service
public class DefectService {
	private DefectMapper defectMapper;
	public DefectService(DefectMapper defectMapper) {
		this.defectMapper = defectMapper;
	}

}
