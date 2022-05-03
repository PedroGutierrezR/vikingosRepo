package com.vikingo.trazap.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vikingo.trazap.app.repository.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	public List<Usuario> findByEmail(String email);
}
