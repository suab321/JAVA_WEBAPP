package com.abhinav.linux.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abhinav.linux.JDBC.ConnectionPooling.ConnectionPool;

public class ConnectionPoolDataBase {

	public static void connect() throws SQLException {
		try {
		Connection con=ConnectionPool.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from users");
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("password"));
		}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
