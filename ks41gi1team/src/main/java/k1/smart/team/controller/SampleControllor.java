package k1.smart.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleControllor {

		@GetMapping("/sample")
		public String sample() {
			return "sample";
		}
}
