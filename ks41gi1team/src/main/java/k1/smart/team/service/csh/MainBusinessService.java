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
	private MainBusiness mainBusinessDetail;
	
	//생성자 메서드
	public MainBusinessService(MainBusinessMapper mainBusinessMapper) {
		this.mainBusinessMapper = mainBusinessMapper;
	};
	
	//사업장 전체 목록 조회
	public List<MainBusiness> getAllMainBusinessList() {
		mainBusinessList = mainBusinessMapper.getAllMainBusinessList();
		String mainBusinessNum;
		for(int i=0; i<mainBusinessList.size(); i++) {
			mainBusinessNum = mainBusinessList.get(i).getMainBusinessCode().replace("mainBusinessCode_","");
			mainBusinessList.get(i).setMainBusinessCode(mainBusinessNum);
		}
		System.out.println(mainBusinessList);
		
		return mainBusinessList;
	}
	
	//사업자번호 중복확인
	public int getBusinessByNum(String businessNum) {
		int businessNumCheck = 0;
		businessNumCheck += mainBusinessMapper.getBusinessByNum(businessNum);
		
		return businessNumCheck;
	}

	//사업장 상세
	public MainBusiness getMainBusinessDetail(String mainBusinessCode) {
		
		
		return mainBusinessDetail;
	}


	

}
