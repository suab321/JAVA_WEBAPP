package com.example.Util;

public class AuthRes {
	private String jwt;
	
	public AuthRes() {}
	public AuthRes(String jwt) {
		this.jwt=jwt;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
