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

import com.vikingos.administracionbodega.repository.BodegaRepository;
import com.vikingos.administracionbodega.repository.MaterialesRepository;
import com.vikingos.administracionbodega.repository.model.Bodega;
import com.vikingos.administracionbodega.repository.model.Materiales;

@SpringBootApplication
public class AdministracionbodegaApplication {

	private static final Logger logger = LoggerFactory.getLogger(AdministracionbodegaApplication.class);

	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private MaterialesRepository materialesRepository;
	
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
	
}
