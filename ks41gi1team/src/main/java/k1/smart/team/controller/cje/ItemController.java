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
import k1.smart.team.dto.cje.Stock;
import k1.smart.team.service.cje.ItemService;

@Controller
public class ItemController {
	private final ItemService itemService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Stock itemInfo; //품목 하나 정보
	private List<Stock> itemList; //품목 배열
	private Map<String, Object> resultMap;
	private boolean chk;
	
	private static final Logger log = LoggerFactory.getLogger(ItemController.class);
	
	/**
	 * 생성자 메서드
	 * @param itemService
	 */
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	 * 품목관리 전체목록 조회
	 * @param model
	 * @return item_list
	 */
	@GetMapping("/k1Item")
	public String itemMain(Model model) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mainBusinessCode", mainBusinessCode);
		
		//품목 전체목록 List<Stock>
		itemList = itemService.getAllItemList(paramMap);
		model.addAttribute("itemList", itemList);
		
		//대분류
		resultMap = itemService.getItemCategory(null, null, null);
		model.addAttribute("largeCategory", resultMap.get("largeCategory"));
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "전체목록");
		
		return "stock/item/item_list";
	}
	
	/**
	 * AJAX :: 특정 조건하에  품목 전체목록 조회
	 * @param model
	 * @param types
	 * @param largeCategory
	 * @param middleCategory
	 * @param smallCategory
	 * @param microCategory
	 */
	@PostMapping("/k1Item")
	public String itemMainAjax(Model model,
			@RequestParam(value="types[]", required = false) List<String> types,
			String largeCategory, String middleCategory, String smallCategory, String microCategory) {
		/*
		log.info("types :: {}",types);
		log.info("largeCategory :: {}",largeCategory);
		log.info("middleCategory :: {}",middleCategory);
		log.info("smallCategory :: {}",smallCategory);
		log.info("microCategory :: {}",microCategory);
		 */
		String typeList = null;
		//분류 배열이 null이 아닐 때
		if(!CommonUtils.isEmpty(types)) {
			StringJoiner str = new StringJoiner("|");
			for(String i : types) {
				str.add(i);
			}
			typeList = str.toString();
		}
		//분류 및 카테고리 세팅
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typeList", typeList);
		paramMap.put("largeCategory", largeCategory);
		paramMap.put("middleCategory", middleCategory);
		paramMap.put("smallCategory", smallCategory);
		paramMap.put("microCategory", microCategory);
		paramMap.put("mainBusinessCode", mainBusinessCode);
		
		log.info("PARAMETER :: {}", paramMap);
		//품목 전체목록 List<Stock>
		itemList = itemService.getAllItemList(paramMap);
		model.addAttribute("itemList", itemList);
		
		return "stock/ajax/item_list_table.html";
	}
	
	/**
	 * 품목 상세정보 조회
	 * @param itemCode
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Item/{itemCode}")
	public String itemInfo(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		//매개변수 검사
		if(CommonUtils.isEmpty(itemCode)) return "redirect:/k1Item";
		
		//품목 상세정보
		resultMap = itemService.getItemInfo(itemCode);
		if(CommonUtils.isEmpty(resultMap)) return "redirect:/k1Item";
		
		//품목정보
		itemInfo = (Stock) resultMap.get("itemInfo");
		log.info("재고 INFO :: {}", itemInfo);
		model.addAttribute("i", itemInfo);
		//해당 품목의 창고별 재고 현황
		model.addAttribute("stockList", resultMap.get("stockList"));
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목정보");
		
		return "stock/item/item_info";
	}
	
	/**
	 * 품목정보등록 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/k1ItemAdd")
	public String addItem(Model model) {
		
		//카테고리목록
		resultMap = itemService.getItemCategory(null, null, null);
		model.addAttribute("largeCategory", resultMap.get("largeCategory"));
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목추가");
		
		return "stock/item/item_add";
	}
	
	/**
	 * AJAX: 품목명 중복 검사
	 * @param itemName
	 * @return boolean
	 */
	@PostMapping("/itemNameValid")
	@ResponseBody
	public boolean itemNameValid(
			@RequestParam(value="itemName", required = false) String itemName) {
		
		log.info("품목명 :: {}", itemName);
		if(CommonUtils.isEmpty(itemName)) return false;
		
		//동일한 이름의 품목이 등록되어 있다면 true 반환
		chk = itemService.itemNameValid(mainBusinessCode, itemName);
		
		return chk;
	}
	
	/**
	 * AJAX: 하위분류 반환
	 * @param largeCategory
	 * @param middleCategory
	 * @param smallCategory
	 * @return
	 */
	@PostMapping("/getLowCategory")
	@ResponseBody
	public Map<String, Object> getLowCategory(
			@RequestParam(value="largeCategory", required = false) String largeCategory,
			@RequestParam(value="middleCategory", required = false) String middleCategory,
			@RequestParam(value="smallCategory", required = false) String smallCategory){
		/*
		 * log.info("대분류 	:: {}", largeCategory);
		 * log.info("중분류 	:: {}", middleCategory);
		 * log.info("소분류 	:: {}", smallCategory);
		 */
		
		//대분류, 중분류, 소분류, 소소분류 조회결과 Map 객체 반환
		resultMap= itemService.getItemCategory(largeCategory, middleCategory, smallCategory);
		return resultMap;
	}
	
	/**
	 * Ajax :: 품목 카테고리 코드 반환
	 * @param categories
	 * @return
	 */
	@PostMapping("/getItemCategoryCode")
	@ResponseBody
	public String getItemCategoryCode(
			@RequestParam(value="categories[]", required = false) List<String> categories){
		//NULL체크
		if(	CommonUtils.isEmpty(categories)
				|| CommonUtils.isEmpty(categories.get(0)) || CommonUtils.isEmpty(categories.get(1))) {
			return null;
		}
		categories.add(mainBusinessCode);
		//카테고리 코드 반환
		return itemService.getItemCategoryCode(categories);
	}
	
	/**
	 * 품목정보 등록 프로세스
	 * @param paramMap
	 */
	@PostMapping("/k1ItemAdd")
	public String addItem(Stock itemInfo) {
		//매개변수 검사
		if(CommonUtils.isEmpty(itemInfo)) return "redirect:/k1ItemAdd";
		//사업장코드 등록
		itemInfo.setMainBusinessCode(mainBusinessCode);
		log.info("품목 INFO :: {}", itemInfo);
		
		//등록 절차 수행: 성공 시 true
		chk = itemService.addItem(itemInfo);
		
		if(chk) return "redirect:/k1Item";
		else return "redirect:/k1ItemAdd";
	}
	
	/**
	 * 품목정보 수정화면 
	 * @param itemCode
	 * @param model
	 */
	@GetMapping("/k1ItemModify/{itemCode}")
	public String modifyItem(
			@PathVariable(value="itemCode", required=false) String itemCode
			,Model model) {
		//품목코드 검사
		if(CommonUtils.isEmpty(itemCode)) return "redirect:/k1Item";
		
		//품목정보반환
		itemInfo = (Stock) itemService.getItemInfo(itemCode).get("itemInfo");
		log.info("품목 INFO :: {}", itemInfo);
		model.addAttribute("i", itemInfo);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "품목수정");
		
		//카테고리목록 조회
		resultMap = itemService.getItemCategory(itemInfo.getLargeCategory(), itemInfo.getMiddleCategory(), itemInfo.getSmallCategory());
		if(CommonUtils.isEmpty(resultMap)) return "stock/item/item_modify";
		
		model.addAttribute("largeCategory", resultMap.get("largeCategory"));
		model.addAttribute("middleCategory", resultMap.get("middleCategory"));
		model.addAttribute("smallCategory", resultMap.get("smallCategory"));
		model.addAttribute("microCategory", resultMap.get("microCategory"));
		
		return "stock/item/item_modify";
	}
	
	/**
	 * 품목정보 수정 프로세스
	 * @param itemInfo
	 */
	@PostMapping("/k1ItemModify")
	public String modifyItem(Stock itemInfo) {
		//품목 검사
		if(CommonUtils.isEmpty(itemInfo) || CommonUtils.isEmpty(itemInfo.getItemCode())) return "redirect:/k1Item";
		log.info("수정할 품목 INFO :: {}", itemInfo);
		//카테고리 생성시 필요한 사업장대표코드
		itemInfo.setMainBusinessCode(mainBusinessCode);
		
		boolean chk = itemService.modifyItem(itemInfo);
		
		if(chk) return "redirect:/k1Item";
		return "redirect:/k1ItemModify/"+itemInfo.getItemCode();
	}
	
	/**
	 * 품목 사용여부 상태변경
	 * @param itemCode
	 * @param isUse
	 * @return
	 */
	@PostMapping("/k1ItemStatus")
	public String itemUseStatus(String itemCode, String isUse) {
		if(CommonUtils.isEmpty(itemCode)) return "redirect:/k1Item";
		
		log.info("상태변경할 품목코드 :: {}",itemCode);
		log.info("변경할 상태 :: {}",isUse);
		
		itemService.modifyUse(itemCode, isUse);
		
		return "redirect:/k1Item";
	}
	
	/**
	 * 품목정보 삭제
	 * @param itemCode
	 */
	@PostMapping("/k1ItemRemove")
	public String removeItem(String itemCode) {
		//삭제진행
		
		return "redirect:/k1Item";
	}
	
	/**
	 * 카테고리 목록 조회
	 * @param model
	 */
	@GetMapping("/k1ItemCategory")
	public String itemCategory(Model model) {
		itemList = itemService.getAllCategories(mainBusinessCode);
		
		model.addAttribute("categories", itemList);
		
		model.addAttribute("SectionTitle", "품목관리");
		model.addAttribute("SectionLocation", "카테고리");
		
		return "stock/item/item_category";
	}
	
	/**
	 * 카테고리 정보 추가 프로세스
	 * @param stock
	 */
	@PostMapping("/k1ItemCategoryAdd")
	public String addItemCategory(Stock stock) {
		//카테고리 정보 확인
		log.info("Stock :: {}", stock);
		
		//카테고리 정보 검사
		if(CommonUtils.isEmpty(stock.getLargeCategory()) || CommonUtils.isEmpty(stock.getMiddleCategory())) {
			return "redirect:/k1ItemCategory";
		}
		//등록 프로세스 진행
		stock.setMainBusinessCode(mainBusinessCode);
		itemService.addItemCategory(stock);
		
		return "redirect:/k1ItemCategory";
	}
	
	/**
	 * 카테고리 정보 수정 프로세스
	 * @param stock
	 */
	@PostMapping("/k1ItemCategoryModify")
	public String modifyItemCategory(Stock stock) {
		//카테고리 정보 확인
		log.info("Stock :: {}", stock);
		
		//카테고리 정보 검사
		if(CommonUtils.isEmpty(stock.getLargeCategory()) || CommonUtils.isEmpty(stock.getMiddleCategory())) {
			return "redirect:/k1ItemCategory";
		}
		//수정 프로세스 진행
		stock.setMainBusinessCode(mainBusinessCode);
		itemService.modifyItemCategory(stock);
		
		return "redirect:/k1ItemCategory";
	}
	
	/**
	 * 카테고리 정보 삭제 프로세스 진행
	 * @param stock
	 * @return
	 */
	@PostMapping("/k1ItemCategoryRemove")
	public String removeItemCategory(String itemCode) {
		//카테고리 삭제 프로세스
		itemService.removeItemCategory(itemCode);
		
		return "redirect:/k1ItemCategory";
	}
}
