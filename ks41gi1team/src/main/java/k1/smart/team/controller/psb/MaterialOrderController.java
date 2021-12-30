package k1.smart.team.controller.psb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.service.psb.MaterialOrderService;

@Controller
public class MaterialOrderController {

		private MaterialOrderService materialOrderService;
		private String mainBusinessCode;
		
		//생성자 메서드
		public MaterialOrderController(MaterialOrderService materialOrderService) {
			this.materialOrderService = materialOrderService;
		}
		
	
		@GetMapping("/k1OrderReg")
		public String addOrder() {
			return "order/order_register";
		}
		

		
		//발주 전체 목록
		@GetMapping("/k1MaterialOrderList")
		public String materialOrderMain(Model model) {
			mainBusinessCode = "fac_ksmartSeoul_Seoul001";
			List<MaterialOrder> materialOrderList = materialOrderService.getAllMaterialOrderList(mainBusinessCode);
			model.addAttribute("title", "발주목록");
			model.addAttribute("materialOrderList", materialOrderList);
			
			return "order/order_list";
		}
}
