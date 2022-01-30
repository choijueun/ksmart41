package k1.smart.team.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k1.smart.team.common.CommonUtils;
import k1.smart.team.dto.pjh.Slip;
import k1.smart.team.dto.psb.MaterialOrderInfo;
import k1.smart.team.dto.psb.ProductOrder;
import k1.smart.team.service.ModalService;

@Controller
public class ModalController {
	private ModalService modalService;
	private List<Slip> salesTransactionList;
	private List<Slip> purchaseTransactionList;
	
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
	public String userListModal(Model model, HttpSession session) {
		model.addAttribute("userList", modalService.getUserList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/user_list";
	}
	
	/**
	 * AJAX :: 거래처정보 전체목록 조회
	 */
	@GetMapping(value="/clientListModal", produces="application/json")
	public String clientListModal(Model model, HttpSession session) {
		model.addAttribute("clientList", modalService.getClientList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/client_list";
	}
	/**
	 * AJAX :: 계약내역 전체목록 조회
	 */
	@GetMapping(value="/contractListModal", produces="application/json")
	public String contractListModal(Model model, HttpSession session) {
		model.addAttribute("contractList", modalService.getContractList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/contract_list";
	}
	
	/**
	 * AJAX :: 자재발주내역 전체목록 조회
	 */
	@GetMapping(value="/materialOrderListModal", produces="application/json")
	public String materialOrderListModal(Model model, HttpSession session) {
		model.addAttribute("materialOrderList", modalService.getMaterialOrderList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/material_order_list";
	}
	
	/**
	 * AJAX :: 자주발주내역 상세(품목 목록) 조회
	 * @param materialOrderCode
	 */
	@GetMapping(value="/materialOrderDetailListModal", produces="application/json")
	@ResponseBody
	public List<MaterialOrderInfo> materialOrderDetailListModal(
			String materialOrderCode, Model model, HttpSession session) {
		return modalService.getMaterialOrderDetailList((String) session.getAttribute("MAINBUSINESSCODE"), materialOrderCode);
	}
	
	/**
	 * AJAX :: 제품수주내역 전체목록 조회
	 */
	@GetMapping(value="/productOrderListModal",  produces="application/json")
	public String productOrderListModal(Model model, HttpSession session) {
		model.addAttribute("productOrderList", modalService.getProductOrderList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/product_order_list";
	}
	/**
	 * AJAX :: 제품수주 상세(품목 목록) 조회
	 */
	@GetMapping(value="/productOrderDetailListModal",  produces="application/json")
	@ResponseBody
	public List<ProductOrder> productOrderDetailListModal(
			String productOrderCode, Model model) {
		return modalService.getProductOrderDetailList(productOrderCode);
	}
	
	
	/**
	 * AJAX :: 품목정보 전체목록 조회
	 * @param model
	 */
	@GetMapping(value="/itemListModal", produces="application/json")
	public String itemListModal(Model model, HttpSession session) {
		model.addAttribute("itemList", modalService.getItemList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/item_list";
	}
	
	/**
	 * AJAX :: 창고정보 전체목록 조회
	 */
	@GetMapping(value="/warehouseListModal", produces="application/json")
	public String warehouseListModal(Model model, HttpSession session) {
		model.addAttribute("warehouseList", modalService.getWarehouseList((String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/warehouse_list";
	}
	
	/**
	 * AJAX :: 특정 품목이 포함된 비용 거래명세서 목록 조회
	 * @param itemCode
	 * @param model
	 */
	@GetMapping(value="/pSlipListByItemModal", produces="application/json")
	public String pSlipByItem(String itemCode, Model model, HttpSession session) {
		model.addAttribute("pSlipListByItem", modalService.getPSlipByItem(itemCode, (String) session.getAttribute("MAINBUSINESSCODE")));
		return "modal/p_slip_list_by_item";
	}
	
	/**
	 * AJAX :: 거래명세서 조회 
	 * @param slipType
	 * @param model
	 */
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
