package com.vikingos.booklet.service;

import com.vikingos.booklet.dao.model.Libro;
import com.vikingos.booklet.dto.LibroDto;

public interface BookletService {

	public int createBook(Libro libro);
	public LibroDto getAllBooks();
	public LibroDto getBook(Libro libro);
	public int updateBook(Libro libro);
	public int updateDisponibilidad(Libro libro);
	public int deleteBook(int  idLibro);
	
}
