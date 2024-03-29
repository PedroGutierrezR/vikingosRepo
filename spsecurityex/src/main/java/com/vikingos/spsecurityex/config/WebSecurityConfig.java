package com.vikingos.spsecurityex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.vikingos.spsecurityex.app.service.impl.AuthServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("pedro").password(passwordEncoder().encode("1234")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("pablo").password(passwordEncoder().encode("4321")).roles("USER");
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests()
//													.antMatchers("/login").permitAll()
//													.anyRequest().authenticated()
//													.and().formLogin().loginPage("/login")
//													.failureUrl("/login?error=true")
//													.usernameParameter("username")
//													.passwordParameter("password")
//													.defaultSuccessUrl("/");
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
												 .antMatchers("/user/**").hasRole("USER")
												 .antMatchers("/login").permitAll()
												 .anyRequest()
												 .authenticated()
												 .and()
												 .formLogin()
												 .loginPage("/login")
												 .successHandler(customAuthenticationSuccessHandler())
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
	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return new CustomAthenticationSuccessHandler();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		return new AuthServiceImpl();
	}
	
}
