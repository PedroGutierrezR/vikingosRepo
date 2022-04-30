package com.vikingos.administracionbodega;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vikingos.administracionbodega.repository.BodegaRepository;
import com.vikingos.administracionbodega.repository.MaterialesRepository;
import com.vikingos.administracionbodega.repository.RolRepository;
import com.vikingos.administracionbodega.repository.UsuarioRepository;
import com.vikingos.administracionbodega.repository.model.Bodega;
import com.vikingos.administracionbodega.repository.model.Materiales;
import com.vikingos.administracionbodega.repository.model.Rol;
import com.vikingos.administracionbodega.repository.model.Usuario;

@SpringBootApplication
public class AdministracionbodegaApplication {

	private static final Logger logger = LoggerFactory.getLogger(AdministracionbodegaApplication.class);

	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private MaterialesRepository materialesRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RolRepository rolRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AdministracionbodegaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createMateriales() {
		return (args) -> {
			
			Bodega bodega1 = new Bodega();
			Bodega bodega2 = new Bodega();
			
			bodega1.setNombreBodega("Mi bodega 1");
			bodega1.setFechaIngreso(LocalDate.now());
			bodega2.setNombreBodega("Mi bodega 2");
			bodega2.setFechaIngreso(LocalDate.now());
			bodegaRepository.save(bodega1);
			bodegaRepository.save(bodega2);
			logger.info(bodega1.toString());
			logger.info(bodega2.toString());
			
			Materiales material1 = new Materiales();			
			material1.setNombreProducto("producto 1");
			material1.setPrecioProducto(10000);
			material1.setFechaIngreso(LocalDate.now());
			material1.setBodega(bodega1);
			Materiales material2 = new Materiales();
			material2.setNombreProducto("producto 2");
			material2.setPrecioProducto(20000);
			material2.setFechaIngreso(LocalDate.now());
			material2.setBodega(bodega2);
			
			materialesRepository.save(material1);
			materialesRepository.save(material2);
			
			logger.info(material1.toString());
			logger.info(material2.toString());
		};
	}

	@Bean
	public CommandLineRunner findAll() {
		return (args) -> {
			List<Bodega> bodegas = new ArrayList<Bodega>();
			Iterable<Bodega> iterableBodegas = bodegaRepository.findAll();
			iterableBodegas.forEach(bodegas::add);
			for (Bodega bodega : bodegas) {
				System.out.println("Dentro del syso" + bodega.toString());
			}
		};
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
			usuario.setRol(rolUser);	

			Usuario usuario2 = new Usuario();
			usuario2.setEmail("jaime@gmail.com");
			usuario2.setNombre("Jaime");
			usuario2.setPassword(passwordEncoder.encode("4321"));
			usuario2.setRol(rolAdmin);
			
			usuarioRepository.save(usuario);
			usuarioRepository.save(usuario2);
			
			logger.info(usuario.toString());
			logger.info(usuario2.toString());
	
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
