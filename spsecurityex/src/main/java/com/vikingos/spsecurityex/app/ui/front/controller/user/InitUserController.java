package com.vikingos.spsecurityex.app.ui.front.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitUserController {

	@GetMapping("/user")
	public String init(ModelMap modelMap) {
		return "/user/init";
	}
	
}
