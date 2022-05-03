package com.vikingo.trazap;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vikingo.trazap.app.repository.BodegaRepository;
import com.vikingo.trazap.app.repository.RolRepository;
import com.vikingo.trazap.app.repository.UsuarioRepository;
import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.repository.model.Rol;
import com.vikingo.trazap.app.repository.model.Usuario;

@SpringBootApplication
public class TrazapApplication {

	private static final Logger logger = LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBodega() {
		return (args) -> {
			Bodega bodega1 = new Bodega();
			Bodega bodega2 = new Bodega();
			bodega1.setDescripcion("Mi Bodega original 1");
			bodega2.setDescripcion("Mi Bodega original 2");
			bodegaRepository.save(bodega1);
			bodegaRepository.save(bodega2);
			logger.info(bodega1.toString());
			logger.info(bodega2.toString());
			bodega1.setDescripcion("Mi Bodega 11");	
			bodegaRepository.save(bodega1);
			logger.info(bodega1.toString());
			bodega2.setDescripcion("Mi Bodega 22");	
			bodegaRepository.save(bodega2);
			logger.info(bodega2.toString());
		};
	}
	
	@Bean
	public CommandLineRunner findAllBodegas() {
		return (args) -> {
			Iterator<Bodega> iteratorBodega = bodegaRepository.findAll().iterator();
			
			while(iteratorBodega.hasNext()) {
				logger.info(iteratorBodega.next().toString());
			}
			
		};
	}
	
	@Bean
	public CommandLineRunner createUsers() {
		return (args) -> {
			Usuario usuarioAdmin = new Usuario();
			Rol rol = new Rol();
			
			rol.setDescripcion("ADMIN");
			
			rolRepository.save(rol);
			
			usuarioAdmin.setNombre("Pedro Gutierrez");
			usuarioAdmin.setEmail("pedro@gmail.com");
			usuarioAdmin.setPassword(passwordEncoder.encode("1234"));
			usuarioAdmin.setRol(rol);
			usuarioRepository.save(usuarioAdmin);
		};
	}
	
	@Bean
	public CommandLineRunner findAllUsuarios() {
		return (args) -> {
			
			Iterator<Usuario> itUsuarios = usuarioRepository.findAll().iterator();
			
			while(itUsuarios.hasNext()) {
				System.out.println("All: " + itUsuarios.next().toString());
			}
		};
	}
	
	@Bean
	public CommandLineRunner findByUserName() {
		return (args) -> {
			
			List<Usuario> listaUsuarios = usuarioRepository.findByEmail("pedro@gmail.com");
			
			for (Usuario usuario : listaUsuarios) {
				System.out.println("Usuario por email: " + usuario.toString());
			}
		};
	}
	
}


