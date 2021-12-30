package k1.smart.team.service.psb;

import java.util.List;
import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.mapper.psb.MaterialOrderMapper;

@Service
public class MaterialOrderService {
	private MaterialOrderMapper materialOrderMapper;
	private List<MaterialOrder> materialOrderList;
	
	//생성자메서드 주입방식
	public MaterialOrderService(MaterialOrderMapper materialOrderMapper) {
		this.materialOrderMapper = materialOrderMapper;
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
