package k1.smart.team.service.csh;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.MainBusiness;
import k1.smart.team.mapper.csh.MainBusinessMapper;
import k1.smart.team.mapper.csh.ClientMapper;

@Service
@Transactional
public class MainBusinessService {
	private MainBusinessMapper mainBusinessMapper;
	private List<MainBusiness> mainBusinessList;
	
	//생성자 메서드
	public MainBusinessService(MainBusinessMapper mainBusinessMapper) {
		this.mainBusinessMapper = mainBusinessMapper;
	};
	
	//사업장 전체 목록 조회
	public List<MainBusiness> getAllMainBusinessList(String mainBusinessCode) {
		mainBusinessList = mainBusinessMapper.getAllMainBusinessList(mainBusinessCode);
		
		
		
		return mainBusinessList;
	}

	

}
