package com.abhinav.FoodOrdering.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.Database.DataBaseService;
import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.UserModel;

@Service
public class AuthService {
	@Autowired
	private DataBaseService dbs;
	
	public boolean isValidLogin(LoginModel lm) throws SQLException {
		return dbs.isUserValid(lm);
	}
	
	public boolean addUser(UserModel um) throws SQLException {
		return dbs.insertUser(um);
	}
}
