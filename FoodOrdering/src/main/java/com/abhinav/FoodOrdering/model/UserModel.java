package com.abhinav.FoodOrdering.model;


public class UserModel {
	private long User_id;
	private String Name;
	private String Email;
	private String Password;
	private String Address;
	public UserModel() {}
	
	public UserModel(long User_id,String Name,String Email,String Password,String Address) {
		this.User_id=User_id;
		this.Name=Name;
		this.Address=Address;
		this.Email=Email;
		this.Password=Password;
	}

	public long getUser_id() {
		return User_id;
	}

	public void setUser_id(long user_id) {
		User_id = user_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
}
