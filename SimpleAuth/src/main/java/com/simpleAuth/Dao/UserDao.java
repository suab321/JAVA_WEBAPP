package com.simpleAuth.Dao;

import java.sql.SQLException;

import com.simpleAuth.model.LoginModel;
import com.simpleAuth.model.RegisterModel;

public interface UserDao {
	public boolean insert(RegisterModel rm) throws SQLException,ClassNotFoundException;
	public boolean validate(LoginModel lm) throws SQLException,ClassNotFoundException;
}
