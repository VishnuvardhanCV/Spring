package com.simplebootapp.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class JwtUserDetailsService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails admin = User.withUsername("admin").password("12345678").roles("ADMIN").build();

		UserDetails user = User.withUsername("user").password("12345678").roles("USER").build();

		return (username == "admin") ? admin : user;
	}

}
