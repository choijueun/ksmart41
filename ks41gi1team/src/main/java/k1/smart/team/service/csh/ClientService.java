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
	};
	
	//거래처 전체 목록 조회
	public List<Client> getAllClientList() {
		clientList = clientMapper.getAllClientList();
		String clientNum;
		for(int i=0; i<clientList.size(); i++) {
			clientNum = clientList.get(i).getClientCode().replace("clientCode_","");
			clientList.get(i).setClientCode(clientNum);
		}
		System.out.println(clientList);
		return clientList;
	};
	
	//거래처 전체목록에서 검색
	public List<Client> getClientListBySearchKey(String searchKey, String searchValue){
		return clientMapper.getClientListBySearchKey(searchKey, searchValue);
	}
	
	

}
