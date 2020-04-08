package com.abhinav.linux.JDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DATABASE {
	public static void connect() throws ClassNotFoundException, SQLException {
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abhinav", "root","");
//		Class.forName("com.mysql.jdbc.Driver");
//		//DQL
//		Statement st=con.createStatement();
//		int id=1;
//		ResultSet rs=st.executeQuery("select * from users where id="+id);
//		while(rs.next()) {
//			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("password"));
//		}
//		st.close();
//		//ended//
//		//DDL
//		//inserting example//
//		String query="insert into users values(?,?,?)";
//		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
//		ps.setInt(1, 3);
//		ps.setString(2, "singh@gmail.com");
//		ps.setString(3, "suab123");
//		try {
//		int result=ps.executeUpdate();
//		System.out.println(result);
//		}catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
////		//ends//
////		//deleting example;
//		String query2="delete from users where id=?";
//		PreparedStatement ps=(PreparedStatement)con.prepareStatement(query2);
//		ps.setInt(1, 3);
//		boolean result=ps.execute();
//		System.out.println(result);
//		
//		//update example
//		String query="update users set name=? where id=?";
//		PreparedStatement ps=(PreparedStatement)con.prepareStatement(query);
//		ps.setString(1, "singhabhinav@gmail.com");
//		ps.setInt(2, 2);
//		int res=ps.executeUpdate();
//		System.out.println(res);
	}
}
