package com.simpleAuth.Service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Service
public class DataBasePooling {
	
	private static HikariConfig config=new HikariConfig();
	private static HikariDataSource ds;
	static {
		System.out.println("fired");
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/Auth");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds=new HikariDataSource(config);
	}
	private DataBasePooling() {}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static HikariDataSource getDataSource(){
		return ds;
	}
}
