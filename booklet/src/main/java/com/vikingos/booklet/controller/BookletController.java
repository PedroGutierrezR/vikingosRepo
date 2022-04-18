package com.vikingos.booklet.controller;

//import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vikingos.booklet.dao.model.Libro;
import com.vikingos.booklet.delegate.BookletDelegate;

@Controller
public class BookletController {

	@Autowired
	private BookletDelegate bookletDelegate;

	@RequestMapping(value = "/getAllBooks", method = { RequestMethod.GET, RequestMethod.PUT })
	public String getAllBooks(ModelMap model) {
		model.put("listaLibros", bookletDelegate.getAllBooks().toString());
		return "booklet";
	}

	@RequestMapping(value = "/addBook", method = { RequestMethod.PUT })
	public String addBook(ModelMap model, @RequestBody Libro libro) {

		//bookletDelegate.createBook(libro);
		//PrintWriter out = resp.getWriter();
//      resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        out.print(cursoDto.toString()); 
//        out.flush(); 
		System.out.println("Hola Put");
		return "forward:/getAllBooks";
	}
	
	
	
}
