package com.simpleAuth.Service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simpleAuth.model.RegisterModel;
import com.simpleAuth.model.LoginModel;

public class JDBCService {
	private static JdbcTemplate jt;
	static {
		jt=new JdbcTemplate(DataBasePooling.getDataSource());
	}
	
	public static boolean insert(RegisterModel rm) {
		String sql="insert into authTable values(?,?)";
		try {
		int a=jt.update(sql,new Object[]{rm.getUserName(),rm.getPassword()});
		if(a==1)
			return true;
		else
			return false;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public static boolean validate(LoginModel lm) {
		String sql="select * from authTable where name=? and password=?";
		try {
		LoginModel l=jt.queryForObject(sql,new Object[] {lm.getUserName(),lm.getPassword()},new LoginMapper());
		return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public static void users() {
		String sql="select * from authTable";
		List<LoginModel> l=jt.query(sql, new RowMapper<LoginModel>() {
			public LoginModel mapRow(ResultSet rs,int rowNum) throws SQLException{
				LoginModel lm=new LoginModel();
				lm.setUserName(rs.getString(1));
				lm.setPassword(rs.getString(2));
				return lm;
			}
		});
		System.out.println(l.size());
	}
}


