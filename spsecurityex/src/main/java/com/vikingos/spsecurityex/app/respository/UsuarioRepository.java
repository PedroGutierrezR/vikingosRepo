package com.vikingos.spsecurityex.app.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vikingos.spsecurityex.app.respository.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public List<Usuario> findByEmail(String email);
	
}
