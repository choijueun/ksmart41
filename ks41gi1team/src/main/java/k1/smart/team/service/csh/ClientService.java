package k1.smart.team.service.csh;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.mapper.csh.ClientMapper;

@Service
@Transactional
public class ClientService {
	private ClientMapper clientMapper;
	private List<Client> clientList;
	
	//생성자 메서드
	public ClientService(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}
	
	//거래처 전체 목록 조회
	public List<Client> getAllClientList(String clientCode) {
		clientList = clientMapper.getAllClientList(clientCode);
		String clientNum;
		for(int i=0; i<clientList.size(); i++) {
			
		}
		
		
		return clientList;
	}
	

}
