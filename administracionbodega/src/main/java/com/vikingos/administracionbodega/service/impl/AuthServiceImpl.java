package com.vikingos.administracionbodega.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.vikingos.administracionbodega.repository.UsuarioRepository;
import com.vikingos.administracionbodega.repository.model.Usuario;


@Service
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> listaUsuarios = usuarioRepository.findByEmail(username);
		Usuario usuario = null;
		UserBuilder builder = null;
		
		if(listaUsuarios == null || listaUsuarios.size() != 1) {
			throw new UsernameNotFoundException(username);
		} else {
			usuario = listaUsuarios.get(0);
			builder = User.withUsername(username);
			builder.password(usuario.getPassword());
			String[] roles = {usuario.getRol().getDescripcion()};
			builder.roles(roles);
		}
		
		return builder.build();
	}

}
