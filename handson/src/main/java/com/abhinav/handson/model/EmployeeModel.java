package com.abhinav.handson.model;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeModel {
	
	@Autowired
	private UserModel um;

	private String id;
	private long salary;
	public EmployeeModel() {}
	public EmployeeModel(String id,long salary) {
		this.salary=salary;
		this.id=id;
	}

	public UserModel getUm() {
		return um;
	}

	public void setUm(UserModel um) {
		this.um = um;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
}
