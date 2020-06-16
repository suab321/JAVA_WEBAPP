package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Sso
public class SpringSecurityOauth2TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2TestApplication.class, args);
	}
}
