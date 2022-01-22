package k1.smart.team.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.dto.psb.MaterialOrderInfo;
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
		if(CommonUtils.isEmpty(inventoryCode)) return null;//재고코드 검사
		model.addAttribute("inventoryCode", inventoryCode);
		return "modal/stock_adj";
	}
	
	/**
	 * AJAX :: 회원 전체목록 조회
	 */
	@GetMapping(value="/userListModal", produces="application/json")
	public String userListModal(Model model) {
		model.addAttribute("userList", modalService.getUserList(mainBusinessCode));
		return "modal/user_list";
	}
	
	/**
	 * AJAX :: 거래처정보 전체목록 조회
	 */
	@GetMapping(value="/clientListModal", produces="application/json")
	public String clientListModal(Model model) {
		model.addAttribute("clientList", modalService.getClientList(mainBusinessCode));
		return "modal/client_list";
	}
	/**
	 * AJAX :: 계약내역 전체목록 조회
	 */
	@GetMapping(value="/contractListModal", produces="application/json")
	public String contractListModal(Model model) {
		model.addAttribute("contractList", modalService.getContractList(mainBusinessCode));
		return "modal/contract_list";
	}
	
	/**
	 * AJAX :: 자재발주내역 전체목록 조회
	 */
	@GetMapping(value="/materialOrderListModal", produces="application/json")
	public String materialOrderListModal(Model model) {
		model.addAttribute("materialOrderList", modalService.getMaterialOrderList(mainBusinessCode));
		return "modal/material_order_list";
	}
	
	/**
	 * AJAX :: 자주발주내역 상세(품목 목록) 조회
	 * @param materialOrderCode
	 */
	@GetMapping(value="/materialOrderDetailListModal", produces="application/json")
	@ResponseBody
	public List<MaterialOrderInfo> materialOrderDetailListModal(String materialOrderCode, Model model) {
		return modalService.getMaterialOrderDetailList(mainBusinessCode, materialOrderCode);
	}
	
	
	/**
	 * AJAX :: 품목정보 전체목록 조회
	 * @param model
	 */
	@GetMapping(value="/itemListModal", produces="application/json")
	public String itemListModal(Model model) {
		model.addAttribute("itemList", modalService.getItemList(mainBusinessCode));
		return "modal/item_list";
	}
	
	/**
	 * AJAX :: 창고정보 전체목록 조회
	 */
	@GetMapping(value="/warehouseListModal", produces="application/json")
	public String warehouseListModal(Model model) {
		model.addAttribute("warehouseList", modalService.getWarehouseList(mainBusinessCode));
		return "modal/warehouse_list";
	}
	
	/**
	 * AJAX :: 특정 품목이 포함된 비용 거래명세서 목록 조회
	 * @param itemCode
	 * @param model
	 */
	@GetMapping(value="/pSlipListByItemModal", produces="application/json")
	public String pSlipByItem(String itemCode, Model model) {
		model.addAttribute("pSlipListByItem", modalService.getPSlipByItem(itemCode, mainBusinessCode));
		return "modal/p_slip_list_by_item";
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
