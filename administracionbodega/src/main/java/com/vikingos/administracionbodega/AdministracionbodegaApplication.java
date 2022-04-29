package com.vikingos.administracionbodega;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vikingos.administracionbodega.repository.BodegaRepository;
import com.vikingos.administracionbodega.repository.model.Bodega;
import com.vikingos.administracionbodega.request.BodegaRequest;
import com.vikingos.administracionbodega.service.BodegaService;

@SpringBootApplication
public class AdministracionbodegaApplication {

	private static final Logger logger = LoggerFactory.getLogger(AdministracionbodegaApplication.class);

	@Autowired
	private BodegaRepository bodegaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AdministracionbodegaApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBodega() {
		return (args) -> {

			Bodega bodega1 = new Bodega();
			Bodega bodega2 = new Bodega();
			
			bodega1.setNombre_bodega("Mi bodega 1");
			bodega1.setFecha_ingreso(LocalDate.now());
			bodega2.setNombre_bodega("Mi bodega 2");
			bodega2.setFecha_ingreso(LocalDate.now());
			bodegaRepository.save(bodega1);
			bodegaRepository.save(bodega2);
			logger.info(bodega1.toString());
			logger.info(bodega2.toString());
		};
	}

}
