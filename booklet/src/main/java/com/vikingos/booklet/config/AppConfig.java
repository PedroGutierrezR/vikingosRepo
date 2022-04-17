package com.vikingos.booklet.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vikingos.booklet.dao.model.Libro;

@Configuration
@ComponentScan("com.vikingos.booklet.*")
public class AppConfig {

	@Bean(name = "listaLibros")
	public List<Libro> getBookList(){
		return new ArrayList<Libro>();
	}
	
}
