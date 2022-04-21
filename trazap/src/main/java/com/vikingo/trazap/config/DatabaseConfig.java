package com.vikingo.trazap.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("url"));
		driverManagerDataSource.setUsername(environment.getProperty("dbuser"));
		driverManagerDataSource.setPassword(environment.getProperty("dbpassword"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
		
		return driverManagerDataSource;
	}
	
}
