package com.vikingo.trazap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vikingo.trazap.app.service.impl.AuthServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
												.antMatchers("/ws/**").hasAnyRole("ADMIN", "USER")
												.antMatchers("/admin/**").hasRole("ADMIN")
												.antMatchers("/user/**").hasRole("USER")
												.antMatchers("/login").permitAll()
												.and()
												.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
												.authorizeRequests()
												.antMatchers(HttpMethod.POST, "/authenticateUser").permitAll()
												.anyRequest()
												.authenticated()
												.and()
												.formLogin()
												.loginPage("/login")
												.successHandler(customAthenticationSuccessHandler())
												.failureUrl("/login?error=true")
												.usernameParameter("username")
												.passwordParameter("password")
												.and()
												.exceptionHandling()
												.accessDeniedPage("/recurso-prohibido");
												
	} 
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler customAthenticationSuccessHandler() {
		return new CustomAthenticationSuccessHandler();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		return new AuthServiceImpl();
	}
	
	
}
