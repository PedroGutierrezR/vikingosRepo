package com.pedrogutierrez.contactmanager.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pedrogutierrez.contactmanager.model.Contacto;

@Configuration
@ComponentScan("com.pedrogutierrez.contactmanager.*")
public class AppConfig {

	@Bean(name = "listaContactos")
	public List<Contacto> getListaContactos(){
		return new ArrayList<Contacto>();
	}
	
}
