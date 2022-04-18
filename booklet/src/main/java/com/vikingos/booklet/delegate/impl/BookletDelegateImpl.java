package com.vikingos.booklet.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingos.booklet.dao.model.Libro;
import com.vikingos.booklet.delegate.BookletDelegate;
import com.vikingos.booklet.dto.LibroDto;
import com.vikingos.booklet.service.BookletService;

@Component("bookletDelegate")
public class BookletDelegateImpl implements BookletDelegate {

	@Autowired
	private BookletService bookletService;
	
	@Override
	public int createBook(Libro libro) {
		return bookletService.createBook(libro);
	}

	@Override
	public LibroDto getAllBooks() {
		return bookletService.getAllBooks();
	}

	@Override
	public LibroDto getBook(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBook(Libro libro) {
		// TODO Auto-generated method stub
		//return 0;
		return bookletService.updateBook(libro);
	}

	@Override
	public int updateDisponibilidad(Libro libro) {
		// TODO Auto-generated method stub
		//return 0;
		return bookletService.updateDisponibilidad(libro);
	}

	@Override
	public int deleteBook(int idLibro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
