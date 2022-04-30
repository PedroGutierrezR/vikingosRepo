package com.vikingos.spsecurityex.app.ui.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(ModelMap modelMap) {
		return "home";
	}
	
}
