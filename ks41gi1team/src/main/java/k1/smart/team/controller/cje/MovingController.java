package k1.smart.team.controller.cje;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import k1.smart.team.dto.cje.Storing;
import k1.smart.team.service.cje.MovingService;

@Controller
public class MovingController {
	private MovingService movingService;
	private String mainBusinessCode = "fac_ksmartSeoul_Seoul_001"; //임시지정
	private Storing movingInfo; //창고이동내역 하나
	private List<Storing> movingList; //창고이동내역 배열
	private Map<String, Object> resultMap;
	/**
	 * 생성자 메서드
	 * @param movingService
	 */
	public MovingController(MovingService movingService) {
		this.movingService = movingService;
	}
	
	/**
	 * 창고이동내역 전체조회
	 * @param model
	 * @return
	 */
	@GetMapping("/k1Moving")
	public String movingMain(Model model) {
		movingList = movingService.getAllShipmentList(mainBusinessCode);
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "창고이동");
		model.addAttribute("movingList", movingList);
		
		return "storing/moving/moving_list";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/k1Moving/{stockAdjCode}")
	public String movingInfo(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		if(stockAdjCode == null || "".equals(stockAdjCode)) return "redirect:/k1Moving";
		
		resultMap = movingService.getMovingInfo(mainBusinessCode, stockAdjCode);
		if(resultMap == null) return "redirect:/k1Moving";
		
		movingInfo = (Storing) resultMap.get("movingInfo");
		movingList = (List<Storing>) resultMap.get("movingDetails");
		
		model.addAttribute("SectionTitle", "물류관리");
		model.addAttribute("SectionLocation", "창고이동");
		model.addAttribute("movingInfo", movingInfo);
		model.addAttribute("movingDetails", movingList);
		
		return "storing/moving/moving_info";
	}
	
	@GetMapping("/k1MovingAdd")
	public String addMoving(Model model) {
		return "storing/moving/moving_add";
	}
	
	@GetMapping("/k1MovingModify/{stockAdjCode}")
	public String modifyMoving(
			@PathVariable(value="stockAdjCode", required=false) String stockAdjCode
			,Model model) {
		return "storing/moving/moving_modify";
	}
}
