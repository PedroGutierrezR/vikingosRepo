package com.vikingo.trazap.app.ui.front.controller.admin;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitAdminController {

	@GetMapping("/admin")
	public String init(ModelMap modelMap, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String[] authorities = auth.getAuthorities()
		Object details = auth.getDetails();
		Object credentials = auth.getCredentials();
		Iterator<GrantedAuthority> itCredentials = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
		Object principal = auth.getPrincipal();
		String name = auth.getName();
		return "/admin/init";
	}
	
}
