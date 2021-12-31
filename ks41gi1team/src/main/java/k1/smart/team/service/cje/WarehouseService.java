package k1.smart.team.service.cje;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.mapper.cje.WarehouseMapper;

@Service
public class WarehouseService {
	private WarehouseMapper warehouseMapper;
	private List<Warehouse> warehouseList; //창고 배열
	private Warehouse warehouseInfo; //창고 하나
	
	public WarehouseService(WarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}
	
	public List<Warehouse> getAllWarehouseList(String mainBusinessCode){
		//전체목록
		warehouseList = warehouseMapper.getAllWarehouseList(mainBusinessCode);
		//코드에서 숫자만 남기기
		String warehouseNum;
		for(int i=0; i<warehouseList.size(); i++) {
			warehouseInfo = warehouseList.get(i);
			warehouseNum = warehouseInfo.getWarehouseCode().replace("warehouseCode_", "");
			warehouseInfo.setWarehouseCode(warehouseNum);
		}
		//적재량 백분율 계산
		float curWeight;
		float maxWeight;
		for(int i=0; i<warehouseList.size(); i++) {
			warehouseInfo = warehouseList.get(i);
			curWeight = warehouseInfo.getCurrentWeight();
			maxWeight = warehouseInfo.getMaxWeight();
			if(maxWeight < 1) {
				return null;
			}
			warehouseInfo.setWeightPer(Math.round(100*curWeight/maxWeight));
		}
		//System.out.println("WarehouseService :: "+warehouseList);
		return warehouseList;
	}

}
