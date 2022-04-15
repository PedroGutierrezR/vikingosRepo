package com.vikingos.booklet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingos.booklet.dao.BookletDao;
import com.vikingos.booklet.dao.model.Libro;
import com.vikingos.booklet.dto.LibroDto;
import com.vikingos.booklet.service.BookletService;

@Service("bookletService")
public class BookletServiceImpl implements BookletService {

	@Autowired
	private BookletDao bookletDao;
	@Autowired
	private LibroDto libroDto;
	
	@Override
	public int createBook() {
		
		return 0;
	}

	@Override
	public LibroDto getAllBooks() {
		libroDto.setListaLibros(bookletDao.getAllBooks());
		return libroDto;
	}

	@Override
	public LibroDto getBook(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBook(Libro libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDisponibilidad(Libro libro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBook(int idLibro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
