package com.example.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/login")
	public String user() {
		return "yesy";
	}

	@GetMapping("/user")
	public String user1(Principal user) {
		@SuppressWarnings("deprecation")
		OAuth2Authentication auth = (OAuth2Authentication)user;
		Authentication authUser = auth.getUserAuthentication();
		Map<String,String> map = (Map<String, String>) authUser.getDetails();
		
		UserEntity userEntity = new UserEntity(map.get("name"), map.get("id"),map.get("email"));
		try {
			userRepo.save(userEntity);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "okay";
	}
	
	@GetMapping("/get")
	public String getUserName(@RequestParam String emailId) {
		UserEntity user = userRepo.findByEmailId(emailId);
		System.out.println(user.getName());
		return user.getName();
	}
}
