package com.vikingo.trazap;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vikingo.trazap.app.repository.BodegaRepository;
import com.vikingo.trazap.app.repository.model.Bodega;

@SpringBootApplication
public class TrazapApplication {

	private static final Logger logger = LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaRepository bodegaRepository;
	
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
//			Bodega bodega = new Bodega();
			Iterator<Bodega> iteratorBodega = bodegaRepository.findAll().iterator();
			
			while(iteratorBodega.hasNext()) {
				logger.info(iteratorBodega.next().toString());
			}
			
		};
	}
	
	
}

// jhb<scjbaskjckajbcak
