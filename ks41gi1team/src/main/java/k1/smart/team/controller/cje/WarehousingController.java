package k1.smart.team.controller.cje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.service.cje.WarehousingService;

@Controller
public class WarehousingController {
	private WarehousingService warehousingService;
	public WarehousingController(WarehousingService warehousingService) {
		this.warehousingService = warehousingService;
	}

	//창고이동내역 전체목록
	@GetMapping("/k1Warehousing")
	public String warehousingMain(Model model) {
		return "storing/warehousing/warehousing_list";
	}
	
	//창고이동내역 상세정보
	@GetMapping("/k1Warehousing/{stockAdjCode}")
	public String warehousingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/warehousing/warehousing_info";
	}
	
	//출하내역 신규등록
	@GetMapping("/k1WarehousingAdd")
	public String addWarehousing(Model model) {
		return "storing/warehousing/warehousing_add";
	}
	
	//출하내역 수정
	@GetMapping("/k1WarehousingModify/{shipmentPlanCode}")
	public String modifyShipment(
			@PathVariable(value="shipmentPlanCode", required=false) String shipmentPlanCode
			,Model model) {
		return "storing/shipment/shipment_modify";
	}
}
