package com.example.Util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.service.MyUserDetailService;

@Component
public class ReqFilter extends OncePerRequestFilter {
	@Autowired
	private MyUserDetailService my_user_details_service;
	@Autowired
	private jwtUtil jwt_util;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	 final String authHeader=request.getHeader("Authorization");
	 String username=null;
	 String jwt=null;
	 
	 if(authHeader!=null && authHeader.startsWith("Bearer ")) {
		 jwt=authHeader.substring(7);
		 username = jwt_util.extractUsername(jwt);
	 }
	 if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		 UserDetails userDetails = this.my_user_details_service.loadUserByUsername(username);
		 if(jwt_util.validateToken(jwt, userDetails)) {
			 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
					 (userDetails,null, userDetails.getAuthorities());
			 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			 SecurityContextHolder.getContext().setAuthentication(authToken);
		 }
	 }
	 filterChain.doFilter(request, response);
	}
	
}
