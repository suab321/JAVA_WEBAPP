package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name="Id", unique=true)
	private int id;
	@Column(name="Name", unique=true)
	private String name;
	@Column(name="socialId", unique=true)
	private String socialId;
	@Column(name="emailId", unique=true)
	private String emailId;
	
	public UserEntity() {}
	
	public UserEntity(String name, String socialId, String emailId) {
		this.name=name;
		this.socialId=socialId;
		this.emailId=emailId;
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

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
