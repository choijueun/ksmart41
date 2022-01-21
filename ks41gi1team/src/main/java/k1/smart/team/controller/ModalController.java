package k1.smart.team.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.service.ModalService;

@Controller
public class ModalController {
	private ModalService modalService;
	private List<Slip> salesTransactionList;
	private List<Slip> purchaseTransactionList;
	
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	
	/**
	 * 생성자 메서드
	 * @param modalService
	 */
	public ModalController(ModalService modalService) {
		this.modalService = modalService;
	}
	
	
	/**
	 * AJAX :: 재고 수정사유 선택
	 * stock_info.html, stock_list.html
	 */
	@GetMapping(value="/stockModifyModal", produces="application/json")
	public String stockModifyModal(String inventoryCode, Model model) {
		//재고코드 검사
		if(CommonUtils.isEmpty(inventoryCode)) return null;
		//재고코드 삽입
		model.addAttribute("inventoryCode", inventoryCode);
		//modal body
		return "modal/stock";
	}
	
	/**
	 * AJAX :: 자재발주내역 전체목록 조회
	 */
	@GetMapping(value="/materialOrderModal", produces="application/json")
	public String materialOrderModal(Model model) {
		//자재발주내역 전체목록
		model.addAttribute("materialOrderList", modalService.getMaterialOrderList(mainBusinessCode));
		//modal body
		return "modal/material_order";
	}
	/**
	 * AJAX :: 창고정보 전체목록 조회
	 */
	@GetMapping(value="/warehouseListModal", produces="application/json")
	public String warehouseListModal(Model model) {
		//창고정보 전체목록
		model.addAttribute("warehouseList", modalService.getWarehouseList(mainBusinessCode));
		//modal body
		return "modal/warehouse";
	}
	/**
	 * AJAX :: 회원 전체목록 조회
	 */
	@GetMapping(value="/userListModal", produces="application/json")
	public String userListModal(Model model) {
		//회원정보 전체목록
		model.addAttribute("userList", modalService.getUserList(mainBusinessCode));
		//modal body
		return "modal/user_list";
	}
	
	@GetMapping(value="/transaction", produces="application/json")
	public String tsModal(String slipType, Model model) {
		System.out.println(slipType);
		if(CommonUtils.isEmpty(slipType)) return null;
		
		
		if("p".equals(slipType)) {
			System.out.println(slipType + "<<--비용 선택시");
			purchaseTransactionList = modalService.purchaseTransactionList();
			model.addAttribute("purchaseTransactionList",purchaseTransactionList);
			return "modal/purchaseTsModal";
		}else if ("s".equals(slipType)) {
			System.out.println(slipType + "<<--매출 선택시");
			salesTransactionList = modalService.salesTransactionList();
			model.addAttribute("salesTransactionList",salesTransactionList);
			return "modal/salesTsModal";
		}
		
		return null;
	}
}
