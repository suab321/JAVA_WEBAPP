package com.abhinav.setter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abhinav.setter.model.UserModel;

@Configuration
public class Config {

	@Bean(name="user")
	public UserModel um() {
		UserModel um=new UserModel();
		um.setAge(20);
		um.setName("abhinav");
		return um;
	}
}
