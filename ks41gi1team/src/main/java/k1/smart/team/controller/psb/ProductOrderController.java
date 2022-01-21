package k1.smart.team.controller.psb;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import k1.smart.team.dto.psb.Contract;
import k1.smart.team.dto.psb.MaterialOrder;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.service.cje.ItemService;
import k1.smart.team.service.csh.ClientService;
import k1.smart.team.service.csh.MainBusinessService;
import k1.smart.team.service.csh.UserService;
import k1.smart.team.service.psb.ContractService;
import k1.smart.team.service.psb.MaterialOrderService;
import k1.smart.team.service.psb.ProductOrderService;

@Controller
@RequestMapping(value = "/k1ProductOrder")
public class ProductOrderController {

	
	private static final Logger log = LoggerFactory.getLogger(MaterialOrderController.class);
	
	private ClientService clientService;
	private MainBusinessService mainBusinessService;
	private UserService userRegService;
	private ItemService itemService;
	private ContractService contractService;
	private MaterialOrder materialOrderInfo; // 발주 하나 정보
	private ProductOrderService productOrderService;
	private MaterialOrderService materialOrderService;
	private String mainBusinessCode;
	private ProductOrder productOrderInfo;

	// 생성자 주입
	public ProductOrderController(ProductOrderService productOrderService, MaterialOrderService materialOrderService, ClientService clientService, ItemService itemService, MainBusinessService mainBusinessService, UserService userRegService, ContractService contractService) {
		this.productOrderService = productOrderService;
		this.materialOrderService = materialOrderService;
		this.clientService = clientService;
		this.itemService = itemService;
		this.mainBusinessService = mainBusinessService;
		this.userRegService = userRegService;
		this.contractService = contractService;
	}

	// 수주 삭제
	@PostMapping("/k1ProductOrderRemove")
	public String k1ProductOrderRemove() {
		String result = productOrderService.k1ProductOrderRemove();
		return "redirect:/productOrder/productOrder_list";
	}

	// 수주관리 상세
	@GetMapping("productOrder/{productOrderCode}")
	public String productOrderInfo(@PathVariable(value = "productOrderCode", required = false) String productOrderCode,
			Model model) {
		// 슈주관리 코드 검사 if(productOrderCode == null
		System.out.println("productOrderCode-->" + productOrderCode);
		if (productOrderCode == null || "".equals(productOrderCode)) {
			System.out.println("수주코드 ERROR");
			return "redirect:/k1MaterialOrder/k1MaterialOrderList";
		}

		// 수주관리 상세정보
		productOrderInfo = productOrderService.getProductOrderInfo(productOrderCode);
		if (productOrderInfo == null) {
			System.out.println("수주관리코드 ERROR");
			return "redirect:/k1MaterialOrder/k1MaterialOrderList";
		}

		model.addAttribute("title", "수주관리 상세");
		model.addAttribute("SectionTitle", "수주관리");
		model.addAttribute("SectionLocation", "상세정보");
		model.addAttribute("productOrderInfo", productOrderInfo);
		return "productOrder/productOrder_info";
	}

	// 수주 등록
	@PostMapping("/k1ProductOrderReg")
	public String addProductOrder(ProductOrder productOrder) {

		System.out.println("ProductOrderController 등록 화면에서 입력받은 값:" + productOrder);
		// insert 처리
		// null 체크
		String productOrderCode = productOrder.getProductOrderCode();
		if (productOrderCode != null && !"".equals(productOrderCode)) {
			productOrderService.addProductOrder(productOrder);
		}

		return "productOrder/productOrder_register";

	}

	@GetMapping("/k1ProductOrderReg")
	public String addProductOrder(Model model) {

		System.out.println("/addProductOrder GET 방식 요청");
		model.addAttribute("title", "수주등록");

		// DB 계약코드 LIST List<ProductOrder> ProductOrderList =
		List<ProductOrder> productOrderList = productOrderService.getProductOrderList();
		model.addAttribute("productOrderList", productOrderList);

		return "productOrder/productOrder_register";

	}

	
	  //전체 수주 조회
	  
	  @GetMapping("/k1ProductOrderList")
	  public String productMain(Model model) {
		  mainBusinessCode = "fac_ksmartSeoul_Seoul001"; 
	  
		  List<ProductOrder> productOrderList = productOrderService.getAllProductOrderList(mainBusinessCode);
	
		  model.addAttribute("title", "수주목록"); 
		  model.addAttribute("productOrderList", productOrderList);
	  
		  List<MaterialOrder> materialOrderList = materialOrderService.getMaterialOrderList(mainBusinessCode);
			model.addAttribute("title", "수.발주 목록");
			model.addAttribute("materialOrderList", materialOrderList);
			System.out.println("materialOrderList-->" + materialOrderList);
		  
	  return "productOrder/productOrder_list"; }
	 
}
