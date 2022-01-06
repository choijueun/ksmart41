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
	
	/**
	 * 생성자 메서드
	 * @param warehouseMapper
	 */
	public WarehouseService(WarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}
	
	/**
	 * 창고 전체목록 조회
	 * @param mainBusinessCode
	 * @return 창고 여러개 정보
	 */
	public List<Warehouse> getAllWarehouseList(String mainBusinessCode){
		//전체목록
		warehouseList = warehouseMapper.getWarehouseList(mainBusinessCode);
		//System.out.println("WarehouseService :: "+warehouseList);
		return warehouseList;
	}
	
	//나중에 SQL문 하나로 합치기
	
	/**
	 * 창고 상세정보 조회
	 * @param warehouseCode
	 * @return 창고 하나 정보
	 */
	public Warehouse getWarehouseInfoByCode(String mainBusinessCode, String warehouseCode) {
		//창고정보
		warehouseInfo = warehouseMapper.getWarehouseInfo(mainBusinessCode, warehouseCode);
		//System.out.println("WarehouseService :: "+warehouseInfo);
		return warehouseInfo;
	}

}
