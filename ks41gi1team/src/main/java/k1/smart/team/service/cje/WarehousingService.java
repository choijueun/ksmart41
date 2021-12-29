package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.WarehousingMapping;

@Service
public class WarehousingService {
	private WarehousingMapping warehousingMapping;
	public WarehousingService(WarehousingMapping warehousingMapping) {
		this.warehousingMapping = warehousingMapping;
	}

}
