package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k1.smart.team.dto.cje.Stock;
import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.service.cje.WarehouseService;

@Controller
public class WarehouseController {
	private WarehouseService warehouseService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시
	private List<Warehouse> warehouseList; //창고 배열
	private Warehouse warehouseInfo; //창고 하나
	private List<Stock> itemList; //품목 배열
	private Map<String, Object> resultMap;
	private static final Logger log = LoggerFactory.getLogger(WarehouseController.class);
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
	
	/**
	 * 창고 상세정보 조회
	 * @param warehouseCode
	 * @param model
	 * @return warehouse_info.html
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Warehouse/{warehouseCode}")
	public String warehouseInfo(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		//매개변수 검사
		if(warehouseCode == null || "".equals(warehouseCode)) return "redirect:/k1Warehouse";
		
		//창고 상세정보
		resultMap = warehouseService.getWarehouseInfo(mainBusinessCode, warehouseCode);
		if(resultMap == null) return "redirect:/k1Warehouse";
		
		warehouseInfo = (Warehouse) resultMap.get("warehouseInfo");
		itemList = (List<Stock>) resultMap.get("itemList");
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고정보");
		model.addAttribute("w", warehouseInfo);
		model.addAttribute("itemList", itemList);
		return "stock/warehouse/warehouse_info";
	}
	
	@GetMapping("/k1WarehouseAdd")
	public String addWarehouse(Model model) {
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고등록");
		
		return "stock/warehouse/warehouse_add";
	}
	
	@PostMapping("/k1WarehouseAdd")
	public String addWarehouse(Warehouse wInfo) {
		log.info("PARAMETER 	:: {}", wInfo.toString());
		
		
		return "redirect:/k1Warehouse";
	}
	
	
	@GetMapping("/k1WarehouseModify/{warehouseCode}")
	public String modifyWarehouse(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		if(warehouseCode == null || "".equals(warehouseCode)) return "redirect:/k1Warehouse";
		
		resultMap = warehouseService.getWarehouseInfo(mainBusinessCode, warehouseCode);
		model.addAttribute("w", resultMap.get("warehouseInfo"));
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고등록");
		
		return "stock/warehouse/warehouse_modify";
	}
	
}
