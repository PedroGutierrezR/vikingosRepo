package com.vikingos.spsecurityex.app.ui.front.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitAdminController {

	@GetMapping("/admin")
	public String init(ModelMap modelMap, HttpSession session) {
		return "/admin/init";
	}
	
}
