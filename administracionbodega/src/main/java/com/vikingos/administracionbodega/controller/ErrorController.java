package com.vikingos.administracionbodega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/recurso-prohibido")
	public String recurso403() {
		return "error/403";
	}
	
}
