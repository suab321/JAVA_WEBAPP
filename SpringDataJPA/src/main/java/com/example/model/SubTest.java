package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubTest {

	@Id
	private int id;
	private String name;
	private String description;

	@ManyToOne
	private TestModel tm;

	SubTest(){}

	public SubTest(int id,String name,String description,int testId) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.tm=new TestModel(testId,"","");
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

	public TestModel getTm() {
		return tm;
	}

	public void setTm(int id) {
		this.tm = new TestModel(id, "", "");
	}
}
