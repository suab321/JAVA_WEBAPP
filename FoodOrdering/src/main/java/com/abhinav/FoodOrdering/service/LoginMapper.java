package com.abhinav.FoodOrdering.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.model.LoginModel;

@Service
public class LoginMapper implements RowMapper<LoginModel> {

	@Override
	public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginModel lm=new LoginModel();
		lm.setEmail(rs.getString(1));
		lm.setPassword(rs.getString(2));
		return lm;
	}
}
