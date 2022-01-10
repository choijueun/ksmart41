package k1.smart.team.service.psb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.mapper.psb.MaterialOrderMapper;


@Service
public class MaterialOrderService {
	private MaterialOrderMapper materialOrderMapper;
	private List<MaterialOrder> materialOrderList;
	private Map<String,Object> resultMap = new HashMap<String,Object>();
	private MaterialOrderInfo materialOrderInfo;
	private List<MaterialOrderInfo> materialOrderInfoList;
	
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
	
	/*
	 * //상세조회 발주 public Map<String, Object> getMaterialOrderInfo(String
	 * mainBusinessCode, String materialOrderCode) { materialOrderInfo =
	 * materialOrderMapper.getMaterialOrderInfo(mainBusinessCode,
	 * materialOrderCode); if(materialOrderInfo == null) {
	 * System.out.println("발주정보 조회결과 없음"); return null; } materialOrderInfoList =
	 * materialOrderMapper.getMaterialOrderInfoList(materialOrderCode);
	 * 
	 * resultMap.clear(); resultMap.put("materialOrderInfo", materialOrderInfo);
	 * resultMap.put("materialOrderInfoList", materialOrderInfoList); return
	 * resultMap; }
	 */
	
	
	//하나의 발주 검색
	public List<MaterialOrder> getMaterialOrderListBySearchKey(String searchKey, String searchValue) {
		
		return materialOrderMapper.getMaterialOrderListBySearchKey(searchKey, searchValue);
	}
	
	//전체 발주 검색
	public List<MaterialOrder> getAllMaterialOrderList(String mainBusinessCode){
		materialOrderList = materialOrderMapper.getAllMaterialOrderList(mainBusinessCode);
	
		String materialOrderNum;
		for(int i=0; i<materialOrderList.size(); i++) {
			materialOrderNum = materialOrderList.get(i).getMaterialOrderCode().replace("material_orderCode_", "");
			materialOrderList.get(i).setMaterialOrderCode(materialOrderNum);
		}
		return materialOrderList;
	}


	



}
