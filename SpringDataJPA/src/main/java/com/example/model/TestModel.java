package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestModel {
	
	@Id
	private int testId;
	private String name;
	private String description;
	
	public TestModel(){}
	
	public TestModel(int id,String name,String desc) {
		this.testId=id;
		this.name=name;
		this.description=desc;
	}

	public int getId() {
		return testId;
	}

	public void setId(int id) {
		this.testId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}
}
