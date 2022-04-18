package com.vikingos.booklet.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.vikingos.booklet.dao.model.Libro;


public class LibroMapper implements RowMapper<Libro> {

	@Autowired
	private Libro libro;
	
	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		libro = new Libro();
		libro.setId(rs.getInt("id_libro"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAnio(rs.getInt("anio"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponibilidad(rs.getString("disponibilidad"));
		
		return libro;
	}
}
