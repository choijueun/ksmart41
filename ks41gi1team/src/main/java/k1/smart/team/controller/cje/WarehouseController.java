package k1.smart.team.controller.cje;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		//사업장대표코드
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		//창고 전체목록
		warehouseList = warehouseService.getAllWarehouseList(paramMap);
		//log.info("창고 LIST :: {}", warehouseList);
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "전체목록");
		model.addAttribute("warehouseList", warehouseList);
		
		return "stock/warehouse/warehouse_list";
	}
	
	/**
	 * AJAX :: 특정 조건하에 창고 전체목록 조회
	 * @param category1
	 * @param category2
	 * @param model
	 */
	@PostMapping("/k1Warehouse")
	public String warehouseMainAjax(Model model,
			@RequestParam(value="category1[]", required = false) List<String> category1,
			@RequestParam(value="category2[]", required = false) List<String> category2) {
		//매개변수 확인
		log.info("category1 :: {}",category1);
		log.info("category2 :: {}",category2);
		//객체 생성
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//분류 배열이 null이 아닐 때
		String category1List = null;
		if(!CommonUtils.isEmpty(category1)) {
			StringJoiner str = new StringJoiner("|");
			for(String i : category1) {
				str.add(i);
			}
			category1List = str.toString();
		}
		paramMap.put("category1List", category1List);
		//유형 배열이 null이 아닐 때
		String category2List = null;
		if(!CommonUtils.isEmpty(category2)) {
			StringJoiner str = new StringJoiner("|");
			for(String i : category2) {
				str.add(i);
			}
			category2List = str.toString();
		}
		paramMap.put("category2List", category2List);
		//사업장대표코드
		paramMap.put("mainBusinessCode", mainBusinessCode);
		
		log.info("PARAMETER :: {}", paramMap);
		//창고 전체목록 List<Warehouse>
		warehouseList = warehouseService.getAllWarehouseList(paramMap);
		model.addAttribute("warehouseList", warehouseList);
		
		return "stock/ajax/warehouse_list_table.html";
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
	 * 창고정보 등록화면
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
	 * 창고정보 등록 프로세스
	 * @param wInfo
	 */
	@PostMapping("/k1WarehouseAdd")
	public String addWarehouse(Warehouse wInfo) {
		log.info("PARAMETER 	:: {}", wInfo);
		if(CommonUtils.isEmpty(wInfo)) return "redirect:/k1Warehouse";
		
		//등록 프로세스
		wInfo.setMainBusinessCode(mainBusinessCode);
		boolean chk = warehouseService.addWarehouse(wInfo);
		
		if(chk) return "redirect:/k1Warehouse";
		return "redirect:/k1WarehouseAdd";
	}
	
	/**
	 * 창고정보 수정화면
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
		model.addAttribute("w", warehouseInfo);
		
		model.addAttribute("SectionTitle", "창고관리");
		model.addAttribute("SectionLocation", "창고등록");
		
		return "stock/warehouse/warehouse_modify";
	}
	
	/**
	 * 창고정보 수정 프로세스
	 * @param wInfo
	 */
	@PostMapping("/k1WarehouseModify")
	public String modifyWarehouse(Warehouse wInfo) {
		//매개변수 검사
		if(CommonUtils.isEmpty(wInfo)) return "redirect:/k1Warehouse";
		
		wInfo.setMainBusinessCode(mainBusinessCode);
		boolean chk = warehouseService.modifyWarehouse(wInfo);
		
		if(chk) return "redirect:/k1Warehouse";
		
		return "redirect:/k1WarehouseModify/"+wInfo.getWarehouseCode();
	}
	
	/**
	 * 창고정보 삭제 프로세스
	 * @param wInfo
	 */
	@PostMapping("/k1WarehouseRemove")
	public String removeWarehouse(String warehouseCode) {
		log.info("DELETE PARAMETER :: {}", warehouseCode);
		//NULL체크
		if(CommonUtils.isEmpty(warehouseCode)) {
			log.info("NULL");
			return "redirect:/k1Warehouse";
		}
		
		log.info("서비스 호출 :: removeWarehouse");
		warehouseService.removeWarehouse(warehouseCode);
		return "redirect:/k1Warehouse";
	}
	
	/**
	 * 창고 적재가능여부 판단
	 * @param totalWeight
	 * @return true: 적재가능, false: 중량초과
	 */
	@PostMapping("/isWarehouseValid")
	@ResponseBody
	public boolean isWarehouseValid(
			@RequestParam(value="totalWeight", required = false) int totalWeight
			,@RequestParam(value="warehouseCode", required = false) String warehouseCode) {
		log.info("적재예정중량 :: {}",totalWeight);
		//NULL체크
		if(CommonUtils.isEmpty(warehouseCode)) {
			return false;
		}
		//창고정보 조회
		resultMap = warehouseService.getWarehouseInfo(mainBusinessCode, warehouseCode);
		//NULL체크
		if(CommonUtils.isEmpty(resultMap)) {
			return false;
		}
		warehouseInfo = (Warehouse) resultMap.get("warehouseInfo");
		if(CommonUtils.isEmpty(warehouseInfo)) {
			return false;
		}
		//중량 계산
		if( warehouseInfo.getCurrentWeight()+totalWeight > warehouseInfo.getMaxWeight() ) {
			//중량 초과
			return false;
		}
		//적재 가능
		return true;
	}
}
