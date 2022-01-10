package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.service.psb.MaterialOrderService;


@Controller
@RequestMapping(value="/k1MaterialOrder")
public class MaterialOrderController {
		
	private static final Logger log = LoggerFactory.getLogger(MaterialOrderController.class);
	
		private MaterialOrderService materialOrderService;
		private String mainBusinessCode;
		private List<MaterialOrderInfo> MaterialOrderInfoList;  //발주 상세정보
		private MaterialOrderInfo MaterialOrderInfo; // 발주 하나 정보
		private Map<String,Object> resultMap;
		
		
		//생성자 메서드
		public MaterialOrderController(MaterialOrderService materialOrderService) {
			this.materialOrderService = materialOrderService;
		}
		
	
		@GetMapping("/k1MaterialOrderReg")
		public String addOrder() {
			return "materialOrder/materialOrder_register";
		}
		
		//발주 수정 	
		@GetMapping("/modify/{materialOrderCode}")
		public String modifyMaterialOrderInfo(
				@RequestParam(value="materialOrderCode", required=false) String materialOrderCode
				,Model model) {
			
			//materialOrderCode 콘솔에 출력(log4j)
			log.info("modifyMaterialOrder materialOrderCode: {}", materialOrderCode);
			
			MaterialOrder materialOrderInfo = materialOrderService.getMaterialOrderInfoByMaterialOrderCode(materialOrderCode);
			model.addAttribute("materialOrderInfo", materialOrderInfo);
			
			model.addAttribute("title", "발주관리: 수정");
			return "materialOrder/materialOrder_modify";
		}
		
		
	/*
	 * //발주관리 상세
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/k1MaterialOrder/{materialOrderCode}") public String
	 * materialOrderInfo(
	 * 
	 * @PathVariable(value="materialOrderCode", required=false) String
	 * materialOrderCode ,Model model) { //발주관리 코드 검사 if(materialOrderCode == null
	 * || "".equals(materialOrderCode)) { System.out.println("발주코드 ERROR"); return
	 * "redirect:/k1MaterialOrder"; } //발주관리 상세정보 resultMap =
	 * materialOrderService.getMaterialOrderInfo(mainBusinessCode,
	 * materialOrderCode); if(resultMap == null) {
	 * System.out.println("발주관리코드 ERROR"); return
	 * "redirect:/k1MaterialOrderList/detail"; }
	 * 
	 * MaterialOrderInfo = (MaterialOrderInfo) resultMap.get("MaterialOrderInfo");
	 * MaterialOrderInfoList = (List<MaterialOrderInfo>)
	 * resultMap.get("MaterialOrderInfoList");
	 * 
	 * model.addAttribute("SectionTitle", "발주관리");
	 * model.addAttribute("SectionLocation", "상세정보");
	 * model.addAttribute("MaterialOrderInfo", MaterialOrderInfo);
	 * model.addAttribute("MaterialOrderInfoList", MaterialOrderInfoList); return
	 * "materialOrder/materialOrder_info"; }
	 */
		
		
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
