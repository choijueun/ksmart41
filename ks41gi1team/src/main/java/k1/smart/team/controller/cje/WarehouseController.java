package k1.smart.team.controller.cje;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.service.cje.WarehouseService;

@Controller
public class WarehouseController {
	private WarehouseService warehouseService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시
	private List<Warehouse> warehouseList; //창고 배열
	private Warehouse warehouseInfo; //창고 하나
	
	/**
	 * 생성자 메서드
	 * @param warehouseService
	 */
	public WarehouseController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	/**
	 * 창고 전체목록 조회
	 * @param model
	 * @return warehouse_list (List<Warehouse>)
	 */
	@GetMapping("/k1Warehouse")
	public String warehouseMain(Model model) {
		//창고 전체목록
		warehouseList = warehouseService.getAllWarehouseList(mainBusinessCode);
		//System.out.println("WarehouseController :: "+warehouseList);
		//System.out.println("WarehouseController warehouseList.get(0).getWarehouseCode() :: "+warehouseList.get(0).getWarehouseCode());
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("warehouseList", warehouseList);
		
		return "stock/warehouse/warehouse_list";
	}
	
	@GetMapping("/k1Warehouse/{warehouseCode}")
	public String warehouseInfo(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		if(warehouseCode == null || "".equals(warehouseCode)) {
			System.out.println("창고코드 ERROR");
			return "redirect:/k1Warehouse";
		}
		
		//창고 상세정보
		warehouseInfo = warehouseService.getWarehouseInfoByCode(mainBusinessCode, warehouseCode);
		
		if(warehouseInfo == null) {
			System.out.println("창고코드 ERROR");
			return "redirect:/k1Warehouse";
		}
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고정보");
		model.addAttribute("warehouseInfo", warehouseInfo);
		return "stock/warehouse/warehouse_info";
	}
	
	@GetMapping("/k1WarehouseAdd")
	public String addWarehouse(Model model) {
		model.addAttribute("title", "창고등록");
		return "stock/warehouse/warehouse_add";
	}
	
	@GetMapping("/k1WarehouseModify/{warehouseCode}")
	public String modifyWarehouse(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		model.addAttribute("title", "창고정보수정");
		model.addAttribute("warehouseCode", warehouseCode);
		return "stock/warehouse/warehouse_modify";
	}
	
}
