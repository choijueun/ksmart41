package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.service.psb.MaterialOrderService;

@Controller
@RequestMapping(value="/k1MaterialOrder")
public class MaterialOrderController {

		private MaterialOrderService materialOrderService;
		private String mainBusinessCode;
		
		//생성자 메서드
		public MaterialOrderController(MaterialOrderService materialOrderService) {
			this.materialOrderService = materialOrderService;
		}
		
	
		@GetMapping("/k1MaterialOrderReg")
		public String addOrder() {
			return "materialOrder/materialOrder_register";
		}
		
		//하나의 발주 검색
		@PostMapping("/k1MaterialOrderOne") 
		public String getSearchContractList( @RequestParam(value="searchKey", required = false) String searchKey
											,@RequestParam(value="searchValue", required = false)String searchValue
											,Model model) {
			System.out.println(searchKey);
			System.out.println(searchValue);
			
			if(searchKey != null && "materialOrderCode".equals(searchKey)) {
			searchKey = "materialOrderCode";
			}else if(searchKey != null && "mainBusinessCode".equals(searchKey)) {
			searchKey = "mainBusinessCode";
			  
			}else if(searchKey != null && "contractCode".equals(searchKey)) {
			searchKey = "contractCode";
			  
			}else if(searchKey != null && "clientCode".equals(searchKey)) {
			searchKey = "clientCode";
			
			}else if(searchKey != null && "managerId".equals(searchKey)) {
			searchKey = "managerId";
			
			}
			  // 검색키 검색어를 통해서 계약목록 조회
				System.out.println(searchKey);
				System.out.println(searchValue);
			  List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderListBySearchKey(searchKey, searchValue);
			  System.out.println(materialOrderList);
			  // 조회된 회원목록 model에 값을 저장
			  model.addAttribute("title", "발주목록");
			  model.addAttribute("materialOrderList", materialOrderList);
			  
			  
			  return "materialOrder/materialOrder_list";
		  }
		
		//발주 전체 목록
		@GetMapping("/k1MaterialOrderList")
		public String materialOrderMain(Model model) {
			mainBusinessCode = "fac_ksmartSeoul_Seoul001";
			List<MaterialOrder> materialOrderList = materialOrderService.getAllMaterialOrderList(mainBusinessCode);
			model.addAttribute("title", "발주목록");
			model.addAttribute("materialOrderList", materialOrderList);
			
			return "materialOrder/materialOrder_list";
		}
}
