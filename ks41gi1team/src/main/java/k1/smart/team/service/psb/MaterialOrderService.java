package k1.smart.team.service.psb;


import java.util.List;


import org.springframework.stereotype.Service;


import k1.smart.team.dto.psb.MaterialOrder;

import k1.smart.team.mapper.psb.MaterialOrderMapper;


@Service
public class MaterialOrderService {
	private MaterialOrderMapper materialOrderMapper;
	private List<MaterialOrder> materialOrderList;
	private MaterialOrder materialOrderInfo;

	
	//생성자메서드 주입방식
	public MaterialOrderService(MaterialOrderMapper materialOrderMapper) {
		this.materialOrderMapper = materialOrderMapper;
	}
	
	//발주 정보 조회
	public MaterialOrder getMaterialOrderInfoByMaterialOrderCode(String materialOrderCode) {
		return materialOrderMapper.getMaterialOrderInfoByMaterialOrderCode(materialOrderCode);
	}
	
	//발주정보 수정
	public int modifyMaterialOrder(MaterialOrder materialOrder) {
		return materialOrderMapper.modifyMaterialOrderInfo(materialOrder);
	}
	
	
	
	//발주 등록 
	public int addMaterialOrder(MaterialOrder materialOrder) {
		
		int result = materialOrderMapper.addMaterialOrder(materialOrder);
		
		return result;
	}
	
	//발주 전체조회 이력 조회
	public List<MaterialOrder> getMaterialOrderList(){
		List<MaterialOrder> materialOrderList = materialOrderMapper.getMaterialOrderList();
		
		return materialOrderList;
	}
	
	
	//전체 발주 검색
	public List<MaterialOrder> getMaterialOrderList(String mainBusinessCode){
		materialOrderList = materialOrderMapper.getMaterialOrderList(mainBusinessCode);
		
		return materialOrderList;
	}
	
	//발주 상세
	public MaterialOrder getMaterialOrderInfo(String materialOrderCode) {
		materialOrderInfo = materialOrderMapper.getMaterialOrderInfo(materialOrderCode);

		System.out.println("materialOrderInfo 세팅전-->:" + materialOrderInfo);
		if(materialOrderInfo == null) {
			System.out.println("발주정보 조회결과 없음");
			return null;
		}

		materialOrderInfo.setMaterialOrderCode(materialOrderCode);
		return materialOrderInfo;
	}
	

	// 발주서 코드 새로 자동으로 표시
	public String getMaterialOrderCode() {
		
		return materialOrderMapper.getMaterialOrderCode();
	}
	
	//발주서 여부 체크
	public int getMaterialOrderByMaterialOrderCode(String materialOrderCode) {
		int result = 0;
		result += materialOrderMapper.getMaterialOrderByMaterialOrderCode(materialOrderCode);
		return result;
	}



	



}
