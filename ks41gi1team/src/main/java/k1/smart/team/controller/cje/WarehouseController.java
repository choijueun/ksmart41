package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.cje.WarehouseService;

@Controller
@RequestMapping(value="/k1Warehouse")
public class WarehouseController {
	private WarehouseService warehouseService;
	
	public WarehouseController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@GetMapping("")
	public String warehouseMain(Model model) {
		model.addAttribute("title", "창고관리");
		return "stock/warehouse/warehouse_list";
	}
	
	@GetMapping("/{warehouseCode}")
	public String warehouseInfo(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		model.addAttribute("title", "창고정보");
		model.addAttribute("warehouseCode", warehouseCode);
		return "stock/warehouse/warehouse_info";
	}
	
	@GetMapping("/add")
	public String addWarehouse(Model model) {
		model.addAttribute("title", "창고등록");
		return "stock/warehouse/warehouse_add";
	}
	
	@GetMapping("/modify/{warehouseCode}")
	public String modifyWarehouse(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		model.addAttribute("title", "창고정보수정");
		model.addAttribute("warehouseCode", warehouseCode);
		return "stock/warehouse/warehouse_modify";
	}
	
}
