package com.in28minutes.rest.webservices.rest.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("user-login-filter")
public class UserLoginDetails {
	
	private Integer code;
	private String email;
	private String password;
	
	public UserLoginDetails() {
		super();
	}

	public UserLoginDetails(Integer code, String email, String password) {
		super();
		this.code = code;
		this.email = email;
		this.password = password;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginDetails [code=" + code + ", email=" + email + ", password=" + password + "]";
	}

}
