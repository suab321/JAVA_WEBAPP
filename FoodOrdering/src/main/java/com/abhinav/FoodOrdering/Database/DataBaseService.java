package com.abhinav.FoodOrdering.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhinav.FoodOrdering.model.LoginModel;
import com.abhinav.FoodOrdering.model.UserModel;

@Service
public class DataBaseService {
	
	@Autowired
	private static ConnectionPool cp;
	
	public boolean isUserValid(LoginModel lm) throws SQLException {
		Connection con=cp.getConnection();
		String query="select * from user where Email=? and Password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, lm.getEmail());
		ps.setString(2, lm.getPassword());
		ResultSet rs=ps.executeQuery();
		return rs.next();
	}
	
	public boolean insertUser(UserModel um) throws SQLException {
		Connection con=cp.getConnection();
		String query="insert into user(Name,Email,Password,Address) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, um.getName());
		ps.setString(2, um.getEmail());
		ps.setString(3, um.getPassword());
		ps.setString(4, um.getAddress());
		try {
			int a=ps.executeUpdate();
			if(a==0)
				return false;
			return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
