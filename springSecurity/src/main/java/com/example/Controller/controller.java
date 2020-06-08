package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Util.AuthReq;
import com.example.Util.AuthRes;
import com.example.Util.jwtUtil;
import com.example.service.MyUserDetailService;

@RestController
public class controller {
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private MyUserDetailService my_user_detail_service;
	@Autowired
	private jwtUtil jwt_util;

	@GetMapping("/secured")
	public String secured() {
		return "Secured";
	}
	@GetMapping("/sec")
	public String sec() {
		return "2";
	}
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthReq req) throws Exception{
		System.out.println(req.getUsername()+" "+req.getPassword());
		try {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
		);
	}catch(BadCredentialsException e) {
			throw new Exception(e.getMessage());
		}
		final UserDetails userdetail = my_user_detail_service.loadUserByUsername(req.getUsername());
		final String jwt = jwt_util.generateToken(userdetail);
		return ResponseEntity.ok(new AuthRes(jwt));
	}
}
