package com.abhinav.FoodOrdering.model;

public class UserModel extends RegisterModel{
	private String id;
	UserModel(){}
	UserModel(String Name,String Email,String Password,String Address,String id){
		super(Name,Email,Password,Address);
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}