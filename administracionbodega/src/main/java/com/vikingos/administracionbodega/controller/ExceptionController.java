package com.vikingos.administracionbodega.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController{

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if(statusCode == 404) {
			return "error/404";
		} else {
			return "error/403";
		}
	}
	
	@GetMapping("/recurso-prohibido")
	public String recurso403() {
		return "error/403";
	}
	
}
