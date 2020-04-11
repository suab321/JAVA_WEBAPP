package com.simpleAuth.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import com.simpleAuth.model.LoginModel;
import com.simpleAuth.model.RegisterModel;

@Service
public class DataBaseService {
//	@Autowired
//	private static DataBasePooling dbp;
	

	//insert users
	public static boolean insert(RegisterModel rm) throws SQLException, ClassNotFoundException {
//		Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Auth","root","");
		Connection con1=DataBasePooling.getConnection();
		String query="insert into authTable values(?,?)";
		PreparedStatement ps=con1.prepareStatement(query);
		ps.setString(1, rm.getUserName());
		ps.setString(2, rm.getPassword());
		try {
			int a=ps.executeUpdate();
			System.out.println(a);
			return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}//ends//
	
	//checking credentials
	public static boolean validate(LoginModel lm) throws SQLException, ClassNotFoundException {
//		Connection con1=con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Auth","root","");
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con1=DataBasePooling.getConnection();
		String query="select password from authTable where name=?";
		PreparedStatement ps=con1.prepareStatement(query);
		ps.setString(1, lm.getUserName());
		try {
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				if(lm.getPassword().equals(rs.getString(1)))
					return true;
				else
					return false;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return false;
	}//ends//
	
}
