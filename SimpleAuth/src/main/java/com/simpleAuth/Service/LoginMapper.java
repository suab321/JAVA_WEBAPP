package com.simpleAuth.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.simpleAuth.model.LoginModel;

@Service
public class LoginMapper implements RowMapper<LoginModel>, RowCallbackHandler {

	public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginModel lm=new LoginModel();
		lm.setPassword(rs.getString(2));
		lm.setUserName(rs.getString(1));
		
		return lm;
	}

	public void processRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
