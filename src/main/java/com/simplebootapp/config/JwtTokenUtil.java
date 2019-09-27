package com.simplebootapp.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.simplebootapp.exceptions.JwtException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
	
	Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public String getUsernameFromToken(String token) throws JwtException {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws JwtException {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) throws JwtException {
		try {
			return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		}
		catch(Exception e) {
			throw new JwtException();
		}	
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		String subject = userDetails.getUsername();
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(secretKey).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) throws JwtException {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()));
	}

}
