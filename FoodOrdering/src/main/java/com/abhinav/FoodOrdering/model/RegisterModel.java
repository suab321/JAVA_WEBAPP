package com.abhinav.FoodOrdering.model;


public class RegisterModel {
	private String Name;
	private String Email;
	private String Password;
	private String Address;
	public RegisterModel() {}
	
	public RegisterModel(String Name,String Email,String Password,String Address) {
		this.Name=Name;
		this.Address=Address;
		this.Email=Email;
		this.Password=Password;
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
