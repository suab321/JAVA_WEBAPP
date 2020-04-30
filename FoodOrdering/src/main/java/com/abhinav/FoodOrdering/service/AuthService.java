package com.abhinav.FoodOrdering.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.Database.SpringDataBaseService;
import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.RegisterModel;
import com.abhinav.FoodOrdering.model.UserModel;

@Service
public class AuthService {
	@Autowired
	private SpringDataBaseService dbs;
	
	public boolean isValidLogin(LoginModel lm) throws SQLException {
		return dbs.isUserValid(lm);
	}

	public boolean addUser(RegisterModel rm) throws SQLException {
		return dbs.insertUser(rm);
	}
}
