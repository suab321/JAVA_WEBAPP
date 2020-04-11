package com.simpleAuth.Dao;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.simpleAuth.Service.DataBaseService;
import com.simpleAuth.Service.JDBCService;
import com.simpleAuth.model.LoginModel;
import com.simpleAuth.model.RegisterModel;

@Component
public class UserDaoImpl implements UserDao {
	public boolean insert(RegisterModel rm) throws ClassNotFoundException, SQLException {
		return JDBCService.insert(rm);
	}
	public boolean validate(LoginModel lm) throws SQLException, ClassNotFoundException{
			return JDBCService.validate(lm);
	}
}
