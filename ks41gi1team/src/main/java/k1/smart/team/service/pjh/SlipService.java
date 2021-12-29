package k1.smart.team.service.pjh;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.mapper.pjh.SlipMapper;

@Service
public class SlipService {
	private SlipMapper slipMapper;
	private List<Slip> p_slipList;
	private List<Slip> s_slipList;
	
	//생성자메서드
	public SlipService(SlipMapper slipMapper) {
		this.slipMapper = slipMapper;
	}
	//전표 전체 목록 조회
	public List<Slip> getAllPSlipList(String mainBusinessCode) {
		p_slipList = slipMapper.getAll_P_SlipList(mainBusinessCode);
		System.out.println("p_slipList: "+p_slipList);
		String slipNum;
		for(int i=0; i<p_slipList.size(); i++) {
			slipNum = p_slipList.get(i).getPurchaseSlipCode().replace("P", "");
			p_slipList.get(i).setPurchaseSlipCode(slipNum);
		}
		return p_slipList;
	}
	public List<Slip> getAllSSlipList(String mainBusinessCode) {
		s_slipList = slipMapper.getAll_S_SlipList(mainBusinessCode);
		System.out.println("s_slipList: "+s_slipList);
		String slipNum;
		for(int i=0; i<s_slipList.size(); i++) {
			slipNum = s_slipList.get(i).getSalesSlipCode().replace("S", "");
			s_slipList.get(i).setPurchaseSlipCode(slipNum);
		}
		return s_slipList;
	}
}
