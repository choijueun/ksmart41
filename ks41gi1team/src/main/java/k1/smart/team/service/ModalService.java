package k1.smart.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.dto.csh.Client;
import k1.smart.team.dto.csh.User;
import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.mapper.cje.ItemMapper;
import k1.smart.team.mapper.cje.WarehouseMapper;
import k1.smart.team.mapper.csh.ClientMapper;
import k1.smart.team.mapper.csh.UserMapper;
import k1.smart.team.mapper.pjh.SlipMapper;
import k1.smart.team.mapper.psb.ContractMapper;
import k1.smart.team.mapper.psb.MaterialOrderMapper;
import k1.smart.team.mapper.psb.ProductOrderMapper;

@Service
@Transactional
public class ModalService {
	@Autowired
	private SlipMapper slipMapper;
	@Autowired
	private MaterialOrderMapper materialOrderMapper;
	@Autowired
	private ProductOrderMapper productOrderMapper;
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WarehouseMapper warehouseMapper;
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 회원정보 전체목록
	 * @param mainBusinessCode
	 */
	public List<User> getUserList(String mainBusinessCode) {
		return userMapper.getAllUserList(mainBusinessCode);
	}
	
	/**
	 * 거래처정보 목록
	 * @param mainBusinessCode
	 */
	public List<Client> getClientList(String mainBusinessCode){
		return clientMapper.getAllClientList(mainBusinessCode);
	}
	
	/**
	 * 계약내역 전체목록
	 * @param mainBusinessCode
	 * @return
	 */
	public List<Contract> getContractList(String mainBusinessCode) {
		return contractMapper.getAllContractList(mainBusinessCode);
	}
	
	/**
	 * 자재발주내역 전체목록
	 * @param mainBusinessCode
	 */
	public List<MaterialOrder> getMaterialOrderList(String mainBusinessCode) {
		return materialOrderMapper.getMaterialOrderList(mainBusinessCode);
	}
	
	/**
	 * 자주발주내역 상세(품목 목록) 조회
	 * @param mainBusinessCode
	 * @param materialOrderCode
	 */
	public List<MaterialOrderInfo> getMaterialOrderDetailList(String mainBusinessCode, String materialOrderCode) {
		return materialOrderMapper.getMaterialOrderInfoList(mainBusinessCode, materialOrderCode);
	}
	
	/**
	 * 수주내역 전체목록
	 * @param mainBusinessCode
	 */
	public List<ProductOrder> getProductOrderList(String mainBusinessCode) {
		return productOrderMapper.getAllProductOrderList(mainBusinessCode);
	}
	
	/**
	 * 자주발주내역 상세(품목 목록) 조회
	 * @param mainBusinessCode
	 * @param materialOrderCode
	 */
	public List<ProductOrder> getProductOrderDetailList(String productOrderCode) {
		return productOrderMapper.getProductOrderInfoList(productOrderCode);
	}
	
	/**
	 * 품목정보 전체목록 조회
	 */
	public List<Stock> getItemList(String mainBusinessCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		paramMap.put("includeN", "INCLUDE");
		return itemMapper.getAllItemList(paramMap);
	}
	
	/**
	 * 창고정보 전체목록
	 * @param mainBusinessCode
	 */
	public List<Warehouse> getWarehouseList(String mainBusinessCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		return warehouseMapper.getWarehouseList(paramMap);
	}
	
	/**
	 * 특정품목의 비용 거래명세서 조회
	 * @param itemCode
	 */
	public List<Slip> getPSlipByItem(String itemCode){
		return slipMapper.getPSlipByItem(itemCode);
	}
	
	/**
	 * 특정품목의 매출 거래명세서 조회
	 * @param itemCode
	 */
	public List<Slip> getSSlipByItem(String itemCode){
		return slipMapper.getSSlipByItem(itemCode);
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
