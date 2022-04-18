package com.vikingos.booklet.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vikingos.booklet.dao.BookletDao;
import com.vikingos.booklet.dao.mapper.LibroMapper;
import com.vikingos.booklet.dao.model.Libro;

@Repository("bookletDao")
public class BookletDaoImpl implements BookletDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Libro> getAllBooks() {
		String sql = "SELECT id_libro, titulo, anio, autor, imprenta, disponibilidad FROM libro";
		return jdbcTemplate.query(sql, new LibroMapper());
	}

	@Override
	public int createBook(Libro libro) {
		String sql = "INSERT INTO libro (id_libro,titulo,anio,autor,imprenta,disponibilidad) VALUES (?,?,?,?,?,?)";
		int lastId = getLastId() + 1;
		return jdbcTemplate.update(sql, lastId, libro.getTitulo(), libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponibilidad());
	}

	@Override
	public Libro getBook(Libro libro) {
		return null;
	}

	@Override
	public int updateBook(Libro libro) {
		//return 0;
		
		String sql = "UPDATE libro WHERE id_libro=?";
		//"UPDATE curso SET descripcion = ? WHERE id_curso = ?"
		int lastId = getLastId() + 1;
		return jdbcTemplate.update(sql, lastId, libro.getTitulo(), libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponibilidad());
	}

	@Override
	public int updateDisponibilidad(Libro libro) {
		return 0;
		//String sql = "UPDATE libro WHERE disponibilidad = ?";
		//int lastId = getLastId() + 1;
		//return jdbcTemplate.update(sql, lastId, libro.getTitulo(), libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponibilidad());
	}

	@Override
	public int deleteBook(int idLibro) {
		return 0;
	}

	private int getLastId() {
		String sql = "SELECT id_libro, titulo, anio, autor, imprenta, disponibilidad FROM libro";
		List<Libro> listaLibros = jdbcTemplate.query(sql, new LibroMapper());
		return listaLibros.get(listaLibros.size() -1 ).getId();
	}

}
