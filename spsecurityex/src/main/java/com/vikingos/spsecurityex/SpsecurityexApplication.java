package com.vikingos.spsecurityex;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vikingos.spsecurityex.app.respository.RolRepository;
import com.vikingos.spsecurityex.app.respository.UsuarioRepository;
import com.vikingos.spsecurityex.app.respository.model.Rol;
import com.vikingos.spsecurityex.app.respository.model.Usuario;

@SpringBootApplication
public class SpsecurityexApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpsecurityexApplication.class);
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RolRepository rolRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpsecurityexApplication.class, args);
	}

	@Bean
	public CommandLineRunner createUser() {
		return (args) -> {
			
			Rol rolAdmin = new Rol();
			rolAdmin.setDescripcion("ADMIN");
			Rol rolUser = new Rol();
			rolUser.setDescripcion("USER");
			rolRepository.save(rolAdmin);
			rolRepository.save(rolUser);
			
			Usuario usuario = new Usuario();
			usuario.setEmail("pedro@gmail.com");
			usuario.setNombre("pedro");
			usuario.setPassword(passwordEncoder.encode("1234"));
			usuario.setRol(rolAdmin);
			
			usuarioRepository.save(usuario);
			
			logger.info(usuario.toString());
	
		};
	}
	
	@Bean
	public CommandLineRunner findByEmailUsuario() {
		return(args) -> {
			List<Usuario> listaUsuarios = usuarioRepository.findByEmail("pedro@gmail.com");
			
			for(Usuario usuario: listaUsuarios) {
				System.out.println("Usuario by Email" + usuario.toString());
			}
			
		};
	}
	
}
