package com.vikingos.administracionbodega.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitAdminController {

	@GetMapping("/admin")
	public String init(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelMap.put("user", auth.getName());
		return "/admin/init";
	}
	
}
