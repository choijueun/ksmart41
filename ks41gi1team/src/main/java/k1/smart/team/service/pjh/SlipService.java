package k1.smart.team.service.pjh;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.mapper.pjh.SlipMapper;

@Service
@Transactional
public class SlipService {
	private SlipMapper slipMapper;
	private List<Slip> p_slipList;
	private List<Slip> s_slipList;
	private Slip purchaseSlipInfo;
	private Slip salesSlipInfo;
	
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
			slipNum = p_slipList.get(i).getPurchaseSlipCode();
			p_slipList.get(i).setPurchaseSlipCode(slipNum);
		}
		return p_slipList;
	}
	public List<Slip> getAllSSlipList(String mainBusinessCode) {
		s_slipList = slipMapper.getAll_S_SlipList(mainBusinessCode);
		String slipNum;
		for(int i=0; i<s_slipList.size(); i++) {
			slipNum = s_slipList.get(i).getSalesSlipCode();
			s_slipList.get(i).setPurchaseSlipCode(slipNum);
		}
		return s_slipList;
	}
	
	public Slip getPurchaseSlipInfo(String purchaseSlipCode) {
		purchaseSlipInfo = slipMapper.getPurchaseSlipInfo(purchaseSlipCode);
		if(purchaseSlipInfo == null) {
			System.out.println("비용전표정보 조회결과 없음");
			return null;
		}
		
		purchaseSlipInfo.setPurchaseSlipCode(purchaseSlipCode);
		return purchaseSlipInfo;
	}
	
	public Slip getSalesSlipInfo(String salesSlipCode) {
		salesSlipInfo = slipMapper.getSalesSlipInfo(salesSlipCode);
		if(salesSlipInfo == null) {
			System.out.println("매출전표정보 조회결과 없음");
			return null;
		}
		
		salesSlipInfo.setPurchaseSlipCode(salesSlipCode);
		return salesSlipInfo;
	}
	
	/**
	 * 전표 등록 절차
	 * @param map
	 * @return 1이면 성공 0이면 실패
	 */
	public void addSlip(Slip slip) {
		System.out.println("220112 addSlip slipSErvice.java");
		//1-1 매출
		if(slip.getSalesTsCode() != null && slip.getPurchaseTsCode() == null) {
			System.out.println("1-1 220112 getSalesTsCode null 아니고 getPurchaseTsCode null 220112 addSlip slipSErvice.java");
//========================================
//전표자동 생성 후 셋팅
			String salesSlipCode = slipMapper.salesSlipNum(slip.getSlipDate());
			slip.setSalesSlipCode(salesSlipCode);
			System.out.println(salesSlipCode + "<-- salesSlipCode 220112 addSlip slipSErvice.java");			
//========================================			
			
			slipMapper.registerSalesSlip(slip);
		//1-2 비용			
		}else if(slip.getPurchaseTsCode() != null && slip.getSalesTsCode() == null ) {
			System.out.println("1-2 220112 getPurchaseTsCode null 아니고 getSalesTsCode null 220112 addSlip slipSErvice.java");
		}
		
		//return 1;
	}
	
	public List<Map<String, Object>> saleTransactionList() {
		List<Map<String, Object>> salesList = slipMapper.saleTransactionList(null);
		return salesList;
	}
}