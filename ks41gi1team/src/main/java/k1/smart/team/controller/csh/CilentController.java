package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Client")
public class CilentController {
	private ClientService clientService;
	private String clientCode;
	
	public CilentController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	//거래처정보 전체목록
	@GetMapping("")
	public String getClientList(Model model) {
		clientCode = "client_agency_001";
		List<Client> clientList = clientService.getAllClientList(clientCode);
		
		return "clientBusiness/client_list";
	}
	
	//거래처 등록
	@GetMapping("k1ClientRegister")
	public String clientRegister(Model model) {
		
		return "clientBusiness/client_register";
	}
	
	

}
