package com.vikingos.administracionbodega.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
								.withUser("Jaime Rojas")
								.password(passwordEncoder().encode("1234"))
								.roles("BODEGA")
								.and()
								.withUser("Pedro Gutierrez")
								.password(passwordEncoder().encode("4321"))
								.roles("BODEGA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
										.antMatchers("/user/**").hasRole("BODEGA")
										.antMatchers("/login").permitAll()
										.anyRequest().authenticated()
										.and().formLogin().loginPage("/login")
										.failureUrl("/login?error=true")
										.usernameParameter("username")
										.passwordParameter("password")
										.defaultSuccessUrl("/user")	
										.and()
										.exceptionHandling()
										.accessDeniedPage("/recurso-prohibido");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
