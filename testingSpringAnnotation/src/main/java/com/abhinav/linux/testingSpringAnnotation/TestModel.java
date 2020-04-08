package com.abhinav.linux.testingSpringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TestModel {
	@Autowired
	private SubTest st;
	
	public SubTest getSt() {
		return st;
	}
	public void setSt(SubTest st) {
		this.st = st;
	}
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void config() {
		System.out.println("abhi is great");
		st.config();
	}
}
