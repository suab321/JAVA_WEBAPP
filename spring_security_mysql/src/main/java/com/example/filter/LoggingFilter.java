package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//applying filter only for testing purposes have nothing to do with this implementation

@Component
@Order(1)
public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println((req.getRequestURI().toString()));
		chain.doFilter(request, response);
	}

	@Bean
	public FilterRegistrationBean<LoggingFilter> filterUrl(){
		FilterRegistrationBean<LoggingFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new LoggingFilter());
	    registrationBean.addUrlPatterns("/users/*");
	         
	    return registrationBean;
	}
}
