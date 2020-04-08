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
		Class.forName("com.mysql.jdbc.Driver");
		//DQL
		Statement st=con.createStatement();
		int id=1;
		ResultSet rs=st.executeQuery("select * from users where id="+id);
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("password"));
		}
		//ended//
		//DQL
		String query="insert into users values(?,?)";
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
	}
}
