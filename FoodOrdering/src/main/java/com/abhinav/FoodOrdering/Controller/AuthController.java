package com.abhinav.FoodOrdering.Controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.RegisterModel;
import com.abhinav.FoodOrdering.model.UserModel;
import com.abhinav.FoodOrdering.service.AuthService;

@RestController
public class AuthController {
	@Autowired
	private AuthService auth;

	@GetMapping("/")
	public String test() {
		return "workn=ing";
	}
	@PostMapping("/login")
	public boolean LoginController(@RequestBody LoginModel lm,HttpServletRequest req) throws SQLException {
		System.out.println(lm.getEmail());
		return auth.isValidLogin(lm);
	}

	@PostMapping("/register")
	public boolean RegisterController(@RequestBody RegisterModel rm,HttpServletRequest req) throws SQLException {
		return auth.addUser(rm);
	}
}
