package com.vikingos.spsecurityex.app.ui.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/recurso-prohibido")
	public String error403() {
		return "/error/403";
	}
	
}
