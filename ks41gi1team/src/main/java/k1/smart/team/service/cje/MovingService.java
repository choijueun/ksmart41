package k1.smart.team.service.cje;

import org.springframework.stereotype.Service;

import k1.smart.team.mapper.cje.MovingMapper;

@Service
public class MovingService {
	private MovingMapper movingMapper;
	public MovingService(MovingMapper movingMapper) {
		this.movingMapper = movingMapper;
	}
}
