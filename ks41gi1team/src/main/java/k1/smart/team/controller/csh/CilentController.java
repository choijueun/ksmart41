package k1.smart.team.controller.csh;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.csh.Client;
import k1.smart.team.service.csh.ClientService;

@Controller
@RequestMapping(value="/k1Client")
public class CilentController {
	private ClientService clientService;
	private String mainBusinessCode;
	
	public CilentController(ClientService clientService) {
		this.clientService = clientService;
	};
	
	//거래처정보 전체목록
	@GetMapping("/k1ClientList")
	public String getClientList(Model model) {
		mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시 지정
		List<Client> clientList = clientService.getAllClientList(mainBusinessCode);
		model.addAttribute("title", "거래처 목록");
		model.addAttribute("clientList", clientList);
		
		return "clientBusiness/client_list";
	};
	
	//거래처 전체목록에서 검색
	@PostMapping("/k1ClientList")
	public String getSearchClientList(@RequestParam(value = "searchKey", required = false) String searchKey
									,@RequestParam(value = "searchValue", required = false) String searchValue
									,Model model) {
		
		if(searchKey != null && "clientCode".equals(searchKey)) {
			searchKey = "clientCode";
		}else if(searchKey != null && "mainBusinessCode".equals(searchKey)) {
			searchKey = "mainBusinessCode";
		}else if(searchKey != null && "businessCategory".equals(searchKey)) {
			searchKey = "businessCategory";
		}else if(searchKey != null && "userId".equals(searchKey)) {
			searchKey = "userId";
		}else if(searchKey != null && "businessName".equals(searchKey)) {
			searchKey = "businessName";
		}else if(searchKey != null && "businessRepresentative".equals(searchKey)) {
			searchKey = "businessRepresentative";
		}else if(searchKey != null && "businessType1".equals(searchKey)) {
			searchKey = "businessType1";
		}else if(searchKey != null && "businessType2".equals(searchKey)) {
			searchKey = "businessType2";
		}else if(searchKey != null && "businessNum".equals(searchKey)) {
			searchKey = "businessNum";
		}else if(searchKey != null && "businessCount".equals(searchKey)) {
			searchKey = "businessCount";
		}else if(searchKey != null && "businessMobile".equals(searchKey)) {
			searchKey = "businessMobile";
		}else if(searchKey != null && "businessPlace".equals(searchKey)) {
			searchKey = "businessPlace";
		}else if(searchKey != null && "businessEmail".equals(searchKey)) {
			searchKey = "businessEmail";
		}else if(searchKey != null && "regDate".equals(searchKey)) {
			searchKey = "regDate";
		}else {
			searchKey = "updateDate";
		};
		//검색키, 검색어를 통해 거래처목록 조회
		System.out.println(searchKey);
		System.out.println(searchValue);
		List<Client> clientList = clientService.getClientListBySearchKey(searchKey, searchValue);
		System.out.println(clientList);
		//조회된 회원목록을 model에 값 저장
		model.addAttribute("title", "거래처목록");
		model.addAttribute("clientList", clientList);
		
		
		return "clientBusiness/client_list";
		
	}
	
	
	
	
	//거래처 등록
	@GetMapping("/k1ClientRegister")
	public String clientRegister(Model model) {
		
		return "clientBusiness/client_register";
	}
	
	

}
