package com.abhinav.handson.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abhinav.handson.model.CollectionModel;
import com.abhinav.handson.model.EmployeeModel;
import com.abhinav.handson.model.UserModel;

@Configuration
public class Config {
	
//	@Bean(name="user")
//	public UserModel getUser() {
//		return new UserModel("abhnav",20);
//	}
//	@Bean(name="employee")
//	public EmployeeModel em() {
//		return new EmployeeModel("851503",2222);
//	}
	@Bean(name="userSetter")
	public UserModel getUser2() {
		UserModel um=new UserModel();
		um.setAge(20);
		um.setName("abhinav");
		return um;
	}
	@Bean(name="empSetter")
	public EmployeeModel em2() {
		EmployeeModel em=new EmployeeModel();
		em.setSalary(2000);
		em.setId("851503");
		return em;
	}
	
	@Bean(name="collection")
	public CollectionModel cm() {
		return new CollectionModel();
	}
	
	@Bean
	public List<Integer> getCollection(){
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		l.add(2);l.add(3);
		return l;
	}
}
