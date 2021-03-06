package k1.smart.team.mapper.cje;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Warehouse;

@Mapper
public interface WarehouseMapper {
	/**
	 * 창고정보 전체조회
	 * @param mainBusinessCode
	 * @return 창고 여러개 정보
	 */
	public List<Warehouse> getWarehouseList(Map<String, Object> paramMap);
	
	/**
	 * 창고정보 상세조회
	 * @param mainBusinessCode, warehouseCode
	 * @return 창고 하나 정보
	 */
	public Warehouse getWarehouseInfo(String mainBusinessCode, String warehouseCode);
	
	/**
	 * 특정 창고의 적재품 조회
	 * @param warehouseCode
	 * @return
	 */
	public List<Stock> getWarehouseStock(String warehouseCode);

	/**
	 * 창고정보 등록 프로세스
	 * @param wInfo
	 * @return 성공시 1 실패시 0
	 */
	public int addWarehouse(Warehouse warehouse);

	/**
	 * 창고정보 수정 프로세스
	 * @param wInfo
	 * @return 성공시 1 실패시 0
	 */
	public int modifyWarehouse(Warehouse warehouse);

	/**
	 * 사용가능여부 수정 프로세스
	 * @param warehouseCode
	 * @param isUse
	 */
	public void modifyUse(String warehouseCode, String status);
	
	/**
	 * 창고정보 삭제
	 * @param warehouseCode
	 * @return 성공시 1 실패시 0
	 */
	public int removeWarehouse(Map<String, Object> paramMap);

}
