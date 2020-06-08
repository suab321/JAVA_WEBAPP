package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestModel {
	
	@Id //primary key
	@GeneratedValue //generates auto value (in this case auto increments the id
	private int id;
	private String name;
	private String description;
	
	public TestModel(){}
	
	public TestModel(int Id,String name,String description) {
		this.id=Id;
		this.name=name;
		this.description=description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
