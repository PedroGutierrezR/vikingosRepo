package cl.desafiolatam.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cl.desafiolatam.model.Contacto;

@Configuration
@ComponentScan("cl.desafiolatam.*")
public class AppConfig {

	@Bean(name = "listaContactos")
	public List<Contacto> getListaContactos(){
		return new ArrayList<Contacto>();
	}
	
}