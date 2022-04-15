package com.vikingos.booklet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vikingos.booklet.service.BookletService;

@Controller
public class BookletController {

	@Autowired
	private BookletService bookletService;
	
	@RequestMapping(value = "/getAllBooks")
	public String getAllBooks(ModelMap model) {
		model.put("listaLibros", bookletService.getAllBooks().toString());
		return "booklet";
	}
	
}
