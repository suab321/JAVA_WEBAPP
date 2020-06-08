package com.example.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class jwtUtil {
	private static String secret_key="javainuse";
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	public <T> T extractClaim(String token, Function<Claims, T>claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
	}
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	public String generateToken(UserDetails user) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims, user.getUsername());
	}
	private String createToken(Map<String, Object> claims, String subject) {
//		System.out.println(new Date(System.currentTimeMillis()+(1000*60*60*10)).toString());
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, secret_key).compact();
	}
	public Boolean validateToken(String token, UserDetails user) {
		final String username = extractUsername(token);
		return username.equals(user.getUsername()) && !isTokenExpired(token);
	}
}
