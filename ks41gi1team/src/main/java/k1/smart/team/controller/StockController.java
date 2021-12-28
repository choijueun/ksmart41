package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k1.smart.team.service.StockService;

@Controller
@RequestMapping(value="/k1Stock")
public class StockController {
	private StockService stockService;

	@GetMapping("")
	public String stockMain(Model model) {
		model.addAttribute("title", "재고관리");
		return "/stock/stock_list";
	}
}
