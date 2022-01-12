package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k1.smart.team.common.CommonUtils;

@Controller
public class ModalController {
	
	/**
	 * AJAX :: 재고 수정사유 선택
	 * stock_info.html, stock_list.html
	 */
	@GetMapping(value="/stockModifyModal", produces="application/json")
	public String stockModifyModal(String inventoryCode, Model model) {
		//System.out.println("INVENTORYCODE :: "+inventoryCode);
		if(CommonUtils.isEmpty(inventoryCode)) return null;
		
		model.addAttribute("inventoryCode", inventoryCode);
		
		return "modal/stock";
	}
	
	/**
	 * AJAX :: 자재발주내역 전체목록 조회
	 */
	@GetMapping(value="/materialOrder", produces="application/json")
	public String materialOrderModal(Model model) {
		
		
		return "modal/material_order";
	}
}
