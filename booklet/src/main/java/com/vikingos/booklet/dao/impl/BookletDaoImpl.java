package com.vikingos.booklet.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vikingos.booklet.dao.BookletDao;
import com.vikingos.booklet.dao.mapper.LibroMapper;
import com.vikingos.booklet.dao.model.Libro;

@Repository("bookletDao")
public class BookletDaoImpl implements BookletDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Libro> getAllBooks() {
		String sql = "SELECT id_libro, titulo, anio, autor, imprenta, disponibilidad FROM libro";
		return jdbcTemplate.query(sql, new LibroMapper());
	}

	@Override
	public int createBook(Libro libro) {
		return 0;
	}

	@Override
	public Libro getBook(Libro libro) {
		return null;
	}

	@Override
	public int updateBook(Libro libro) {
		return 0;
	}

	@Override
	public int updateDisponibilidad(Libro libro) {
		return 0;
	}
	
	@Override
	public int deleteBook(int idLibro) {
		return 0;
	}



	
	
}
