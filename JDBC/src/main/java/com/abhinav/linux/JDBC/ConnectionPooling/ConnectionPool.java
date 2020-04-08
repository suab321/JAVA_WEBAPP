package com.abhinav.linux.JDBC.ConnectionPooling;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	private static HikariConfig config=new HikariConfig();
	private static HikariDataSource ds;
	static {
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/abhinav");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds=new HikariDataSource(config);
	}
	
	private ConnectionPool() {
//		try {
//		config.setDriverClassName("com.mysql.jdbc.Driver");
//		config.setJdbcUrl("jdbc:mysql://localhost:3306/abhinav");
//		config.setUsername("root");
//		config.setPassword("");
//		config.addDataSourceProperty( "cachePrepStmts" , "true" );
//        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
//        ds=new HikariDataSource(config);
//		}catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			return ds.getConnection();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
