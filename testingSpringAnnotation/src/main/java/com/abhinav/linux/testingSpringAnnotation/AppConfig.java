package com.abhinav.linux.testingSpringAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public TestModel cObject() {
		return new TestModel();
	}
	@Bean
	public SubTest c1Object() {
		return new SubTest();
	}
}
