//package com.simplebootapp.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("config");
//		http
//			.authorizeRequests().antMatchers("/Employee/**").hasRole("USER")
//				.antMatchers("/").hasRole("USER")			
//				.and()
//			.formLogin();	
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("configGlobal");
//		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth
//			.inMemoryAuthentication()
//				.withUser(users.username("user").password("password").roles("USER"));
//	}
//	
//}