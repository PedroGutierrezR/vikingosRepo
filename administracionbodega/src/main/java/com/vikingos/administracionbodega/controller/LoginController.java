package com.vikingos.administracionbodega.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(ModelMap modelMap, HttpSession session) {
		return "login";
	}
	
}
