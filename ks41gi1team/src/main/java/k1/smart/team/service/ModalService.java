package k1.smart.team.service;

import java.util.List;

import org.springframework.stereotype.Service;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.mapper.ModalMapper;

@Service
public class ModalService {
	private ModalMapper modalMapper;
	public ModalService(ModalMapper modalMapper) {
		this.modalMapper = modalMapper;
	}
	
	public List<MaterialOrder> getMaterialOrderList() {
		return modalMapper.getMaterialOrderList();
	}

}
