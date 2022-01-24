package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Client")
public class ClientController {
	private ClientService clientService;
	private Client clientDetail; //거래처 상세
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	};
	
	//거래처정보 전체목록
	@GetMapping("/clientList")
	public String getClientList(Model model) {
		
		List<Client> clientList = clientService.getAllClientList();
		
		model.addAttribute("SectionTitle", "거래처 조회");
		model.addAttribute("clientList", clientList);
		
		return "clientBusiness/client_list";
	};
	
	//거래처 등록 아이디 조회
	@GetMapping("/clientRegister")
	public String clientRegister(Model model) {
		model.addAttribute("SectionTitle", "거래처 등록");
		return "clientBusiness/client_register";
	}
	
	//거래처 상세정보
	@GetMapping("/clientDetail/{clientCode}")
	public String getClientDetail(
			 @PathVariable(value = "clientCode", required = false) String clientCode
			,Model model) {
		System.out.println(clientCode);
		
		//거래처코드 검사
		if(clientCode == null || "".equals(clientCode)) {
			System.out.println("거래처코드 error");
			return "redirect:/clientList";
		}
		
		//거래처 상세
		clientDetail = clientService.getClientDetail(clientCode);
		if(clientDetail == null) {
			System.out.println("거래처정보 상세 error");
			return "redirect:/clientList";
		}
		model.addAttribute("SectionTitle", "거래처정보 상세");
		model.addAttribute("clientDetail", clientDetail);
		return "clientBusiness/client_detail";
	}
	
	//거래처정보 수정
	@GetMapping("/modify/{clientCode}")
	public String modifyClient(
			@PathVariable(value = "clientCode", required = false) String clientCode
			,Model model) {
		
		Client getAllClientDetail = clientService.getClientDetail(clientCode);
		model.addAttribute("getAllClientDetail", getAllClientDetail);
		System.out.println(clientCode+"받아온 clientCode (controller)");
		if(clientCode != null && !"".equals(clientCode)) {
			Client getClient = clientService.getClientDetail(clientCode);
			model.addAttribute("getClient", getClient);
		}
		
		model.addAttribute("SectionTitle", "거래처 상셰: 수정");
		model.addAttribute("clientCode", clientCode);
		return "clientBusiness/client_modify";
	}
	//거래처정보 수정
	@PostMapping("/modify/{clientCode}")
	public String modifyClient(Client client) {
		clientService.modifyClient(client);
		return "redirect:/k1Client/clientList";
	}
	
	
	
	
	

}
