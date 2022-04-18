package com.vikingos.booklet.dao;

import java.util.List;

import com.vikingos.booklet.dao.model.Libro;

public interface BookletDao {

	public int createBook(Libro libro);
	public List<Libro>getAllBooks();
	public Libro getBook(Libro libro);
	public int updateBook(Libro libro);
	public int updateDisponibilidad(Libro libro);
	public void deleteBook(int idLibro);
	
}
