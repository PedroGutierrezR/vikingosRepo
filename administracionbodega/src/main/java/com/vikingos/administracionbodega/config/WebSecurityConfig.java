package com.vikingos.administracionbodega.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.vikingos.administracionbodega.service.impl.AuthServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**")
				.hasRole("USER").antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").successHandler(customAuthenticationSuccessHandler())
				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password").and()
				.exceptionHandling().accessDeniedPage("/recurso-prohibido");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CustomAthenticationSuccessHandler();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new AuthServiceImpl();
	}

}
