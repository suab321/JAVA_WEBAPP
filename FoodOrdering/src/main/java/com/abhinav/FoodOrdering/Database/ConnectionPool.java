package com.abhinav.FoodOrdering.Database;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Service
//@PropertySource("classpath:application.properties")
public class ConnectionPool{
	public ConnectionPool() {}
	
//	@Value("${spring.datasource.driver-class-name}")
	static String driverName;
//	System.out.println(driverName);
	
	@Value("${spring.datasource.url}")
	static String url;
	
	@Value("spring.datasource.username")
	static String userName;
	
	@Value("spring.datasource.password")
	static String Password;
	
	private static HikariConfig config=new HikariConfig();
	private static HikariDataSource ds;
	static {
//		config.setDriverClassName(driverName);
//		config.setJdbcUrl(url);
//		config.setUsername(userName);
//		config.setPassword(Password);
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/FoodOrdering");
//		config.setJdbcUrl(url);
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds=new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	public static HikariDataSource getDataSource() {
		return ds;
	}
}
