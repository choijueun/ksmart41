package k1.smart.team.service.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.mapper.cje.StoringMapper;

@Service
public class WarehousingService {
	private StoringMapper storingMapper;
	public WarehousingService(StoringMapper storingMapper) {
		this.storingMapper = storingMapper;
	}
	public Map<String, Object> getWarehousingInfo(String mainBusinessCode, String stockAdjCode) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Storing> getAllWarehousingList(String mainBusinessCode) {
		return null;
	}

}
