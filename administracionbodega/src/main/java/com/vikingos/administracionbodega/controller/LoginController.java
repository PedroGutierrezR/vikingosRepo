package com.vikingos.administracionbodega.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getName().equals("anonymousUser")) {
			modelMap.put("user", auth.getName());
			return "user/init";
		}
		return "login";
	}
	

	
}
