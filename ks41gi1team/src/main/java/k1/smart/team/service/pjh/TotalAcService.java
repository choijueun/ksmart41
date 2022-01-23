package k1.smart.team.service.pjh;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.TotalAc;
import k1.smart.team.mapper.pjh.TotalAcMapper;

@Service
public class TotalAcService {
	private TotalAcMapper totalAcMapper;
	private List<TotalAc> totalAcList;
	
	public TotalAcService(TotalAcMapper totalAcMapper) {
		this.totalAcMapper = totalAcMapper;
	}
	
	public List<TotalAc> getTotalAcList(String mainBusinessCode){
		totalAcList = totalAcMapper.getTotalAcList(mainBusinessCode);
		
		return totalAcList;
	}
}