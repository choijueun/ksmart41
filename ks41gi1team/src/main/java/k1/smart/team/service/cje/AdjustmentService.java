package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.AdjustmentMapper;

@Service
public class AdjustmentService {
	private AdjustmentMapper adjMapper;
	public AdjustmentService(AdjustmentMapper adjMapper) {
		this.adjMapper = adjMapper;
	}
}
