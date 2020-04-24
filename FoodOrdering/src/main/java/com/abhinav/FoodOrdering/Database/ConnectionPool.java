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
//@Configuration
@PropertySource("classpath:application.properties")
public class ConnectionPool{
	public ConnectionPool() {}
	
	@Value("${spring.datasource.driver-class-name}")
	private static String driverName;
	@Value("spring.datasource.url")
	private static String url;
	@Value("spring.datasource.username")
	private static String userName;
	@Value("spring.datasource.password")
	private static String Password;
	
	private static HikariConfig config=new HikariConfig();
	private static HikariDataSource ds;
	static {
		config.setDriverClassName(driverName);
		config.setJdbcUrl(url);
		config.setUsername(userName);
		config.setPassword(Password);
		config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds=new HikariDataSource(config);
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
