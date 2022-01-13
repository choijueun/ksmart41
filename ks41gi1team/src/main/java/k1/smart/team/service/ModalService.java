package k1.smart.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.mapper.ModalMapper;
import k1.smart.team.mapper.pjh.SlipMapper;

@Service
public class ModalService {
	private ModalMapper modalMapper;
	private SlipMapper slipMapper;
	public ModalService(ModalMapper modalMapper, SlipMapper slipMapper) {
		this.modalMapper = modalMapper;
		this.slipMapper = slipMapper;
	}
	
	public List<MaterialOrder> getMaterialOrderList() {
		return modalMapper.getMaterialOrderList();
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
