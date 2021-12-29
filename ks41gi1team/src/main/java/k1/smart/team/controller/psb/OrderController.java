package k1.smart.team.controller.psb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

		@GetMapping("/k1OrderReg")
		public String addOrder() {
			return "order/order_register";
		}
		
		@GetMapping("/k1OrderList")
		public String getAllOrder() {
			return "order/order_list";
		}
}
