package com.vikingos.booklet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addBook(ModelMap model, @RequestBody Libro libro, HttpServletResponse response) throws IOException {

		int resultado = bookletDelegate.createBook(libro);
		if (resultado == 1) {
			bookletDelegate.getAllBooks().setMensaje("Agregado Correctamente");
		} else {
			bookletDelegate.getAllBooks().setMensaje("Error al agregar");
		}

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(bookletDelegate.getAllBooks().toString());
		out.flush();

		return "booklet";
	}

	@RequestMapping(value = "/deleteBook", method = { RequestMethod.POST })
	public String deleteBook(ModelMap model, @RequestParam int idLibro) {
		bookletDelegate.deleteBook(idLibro);
		return "booklet";
	}

}
