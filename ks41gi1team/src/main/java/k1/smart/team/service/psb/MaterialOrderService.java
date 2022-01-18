package k1.smart.team.service.psb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.mapper.psb.MaterialOrderMapper;
import k1.smart.team.mapper.psb.ProductOrderMapper;


@Service
public class MaterialOrderService {
	private MaterialOrderMapper materialOrderMapper;
	private List<MaterialOrder> materialOrderList;
	private Map<String,Object> resultMap = new HashMap<String,Object>();
	private MaterialOrder materialOrderInfo;
	private List<MaterialOrder> materialOrderInfoList;
	private ProductOrder productOrderInfo;
	private ProductOrderMapper productOrderMapper;
	
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

		if(materialOrderInfo == null) {
			System.out.println("발주정보 조회결과 없음");
			return null;
		}

		materialOrderInfo.setMaterialOrderCode(materialOrderCode);
		System.out.println("materialOrderInfo-->:" + materialOrderInfo);
		return materialOrderInfo;
	}
	//수주 상세
		public ProductOrder getProductOrderInfo(String productOrderCode) {
			productOrderInfo = productOrderMapper.getProductOrderInfo(productOrderCode);

			if(productOrderInfo == null) {
				System.out.println("수주정보 조회결과 없음");
				return null;
			}

			productOrderInfo.setProductOrderCode(productOrderCode);
			System.out.println("productOrderInfo-->:" + productOrderInfo);
			return productOrderInfo;
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
