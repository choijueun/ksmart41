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

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.cje.Warehouse;
import k1.smart.team.service.cje.WarehouseService;

@Controller
public class WarehouseController {
	private final WarehouseService warehouseService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시
	private Map<String, Object> resultMap;
	private Warehouse warehouseInfo; //창고정보
	private List<Warehouse> warehouseList; //창고배열
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
	 */
	@GetMapping("/k1Warehouse")
	public String warehouseMain(Model model) {
		//창고 전체목록
		warehouseList = warehouseService.getAllWarehouseList(mainBusinessCode);
		log.info("창고 LIST :: {}", warehouseList);
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("warehouseList", warehouseList);
		
		return "stock/warehouse/warehouse_list";
	}
	
	/**
	 * 창고 상세정보 조회
	 * @param warehouseCode
	 * @param model
	 */
	@GetMapping("/k1Warehouse/{warehouseCode}")
	public String warehouseInfo(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(warehouseCode)) return "redirect:/k1Warehouse";
		
		//창고 상세정보 조회결과
		resultMap = warehouseService.getWarehouseInfo(mainBusinessCode, warehouseCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehouse";
		
		//창고 한줄정보 Warehouse
		warehouseInfo = (Warehouse) resultMap.get("warehouseInfo");
		log.info("창고 INFO :: {}", warehouseInfo);
		model.addAttribute("w", warehouseInfo);
		//창고 적재품 목록 List<Stock>
		model.addAttribute("itemList", resultMap.get("itemList"));
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고정보");
		
		return "stock/warehouse/warehouse_info";
	}
	
	/**
	 * 창고정보 등록 페이지 첫 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/k1WarehouseAdd")
	public String addWarehouse(Model model) {
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고등록");
		
		return "stock/warehouse/warehouse_add";
	}
	
	/**
	 * 창고정보 신규등록 절차 수행
	 * @param wInfo
	 */
	@PostMapping("/k1WarehouseAdd")
	public String addWarehouse(Warehouse wInfo) {
		log.info("PARAMETER 	:: {}", wInfo);
		if(CommonUtils.isEmpty(wInfo)) return "redirect:/k1Warehouse";
		
		wInfo.setMainBusinessCode(mainBusinessCode);
		warehouseService.addWarehouse(wInfo);
		
		return "redirect:/k1Warehouse";
	}
	
	/**
	 * 창고정보 수정화면 첫페이지
	 * @param warehouseCode
	 * @param model
	 */
	@GetMapping("/k1WarehouseModify/{warehouseCode}")
	public String modifyWarehouse(
			@PathVariable(value="warehouseCode", required=false) String warehouseCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(warehouseCode)) return "redirect:/k1Warehouse";
		
		//창고 상세정보 조회결과
		resultMap = warehouseService.getWarehouseInfo(mainBusinessCode, warehouseCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Warehouse";
		
		//창고정보 Warehouse
		warehouseInfo = (Warehouse) resultMap.get("warehouseInfo");
		log.info("창고 INFO :: {}", warehouseInfo);
		model.addAttribute("w", warehouseInfo);
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고등록");
		
		return "stock/warehouse/warehouse_modify";
	}
	
	@PostMapping("/k1WarehouseModify")
	public String modifyWarehouse(Warehouse wInfo) {
		//매개변수 검사
		if(CommonUtils.isEmpty(wInfo)) return "redirect:/k1Warehouse";
		
		wInfo.setMainBusinessCode(mainBusinessCode);
		warehouseService.modifyWarehouse(wInfo);
		
		return "redirect:/k1Warehouse";
	}
	
	
}
