package com.simpleAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.simpleAuth.model.LoginModel;
import com.simpleAuth.model.RegisterModel;

@ComponentScan
@Configuration
public class SimpleAuthConfig {
	
	@Bean(name="login")
	public LoginModel loginModel() {
		return new LoginModel();
	}

	@Bean(name="register")
	public RegisterModel registerModel() {
		return new RegisterModel();
	}
}
