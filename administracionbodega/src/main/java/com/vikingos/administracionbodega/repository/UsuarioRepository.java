package com.vikingos.administracionbodega.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vikingos.administracionbodega.repository.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public List<Usuario> findByEmail(String email);
	
}
