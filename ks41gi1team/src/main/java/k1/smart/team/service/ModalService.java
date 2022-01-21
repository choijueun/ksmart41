package k1.smart.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.mapper.cje.WarehouseMapper;
import k1.smart.team.mapper.csh.UserMapper;
import k1.smart.team.mapper.pjh.SlipMapper;
import k1.smart.team.mapper.psb.MaterialOrderMapper;

@Service
public class ModalService {
	private SlipMapper slipMapper;
	private MaterialOrderMapper materialOrderMapper;
	
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	public ModalService(SlipMapper slipMapper, MaterialOrderMapper materialOrderMapper) {
		this.slipMapper = slipMapper;
		this.materialOrderMapper = materialOrderMapper;
	}
	
	/**
	 * 자재발주내역 전체목록
	 * @param mainBusinessCode
	 */
	public List<MaterialOrder> getMaterialOrderList(String mainBusinessCode) {
		return materialOrderMapper.getMaterialOrderList(mainBusinessCode);
	}
	
	/**
	 * 창고정보 전체목록
	 * @param mainBusinessCode
	 */
	public List<Warehouse> getWarehouseList(String mainBusinessCode) {
		return warehouseMapper.getWarehouseList(mainBusinessCode);
	}
	
	public List<User> getUserList(String mainBusinessCode) {
		return userMapper.getAllUserList(mainBusinessCode);
	}
	
	public List<Slip> salesTransactionList() {
		List<Slip> salesTransactionList = slipMapper.salesTransactionList();
		return salesTransactionList;
	}

	public List<Slip> purchaseTransactionList() {
		List<Slip> purchaseTransactionList = slipMapper.purchaseTransactionList();
		return purchaseTransactionList;
	}


}
