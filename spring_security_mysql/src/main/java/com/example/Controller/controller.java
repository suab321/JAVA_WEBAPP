package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	@Autowired
	AuthenticationManager authManager;

	@RequestMapping("/")
	public String all() {
		return "HEllO";
	}

	@RequestMapping("/user")
	public String user() {
		return "Hello User";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "Hello Admin";
	}
}
