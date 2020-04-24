package com.abhinav.FoodOrdering.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.UserModel;
import com.abhinav.FoodOrdering.service.AuthService;

@RestController
public class AuthController {
	@Autowired
	private AuthService auth;
	

	@PostMapping
	public boolean LoginController(@RequestBody LoginModel lm) throws SQLException {
		return auth.isValidLogin(lm);
	}

	@PostMapping
	public boolean RegisterController(@RequestBody UserModel um) throws SQLException {
		return auth.addUser(um);
	}
}
