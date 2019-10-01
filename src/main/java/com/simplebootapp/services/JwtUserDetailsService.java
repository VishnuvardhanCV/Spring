package com.simplebootapp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class JwtUserDetailsService implements UserDetailsService {

	
private List<GrantedAuthority> buildUserAuthority(String role) {
    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
    setAuths.add(new SimpleGrantedAuthority(role));
    List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(
            setAuths);
    return result;
}

private User buildUserForAuthentication(UserDetails admin,
        List<GrantedAuthority> authorities) {
    return new User(admin.getUsername(), admin.getPassword(),
            admin.isEnabled(), true, true, true, authorities);
}

@SuppressWarnings("deprecation")
@Override
public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
	UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("12345678").roles("ADMIN").build();
	List<GrantedAuthority> authorities = buildUserAuthority("Role");
	UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345678").roles("USER").build();
	if(username == "admin")
		return buildUserForAuthentication(admin, authorities);
	return buildUserForAuthentication(user, authorities);
    
}

}
