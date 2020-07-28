package com.in28minutes.rest.webservices.rest.bean;

public class AppBean {

	private String message;	

	@Override
	public String toString() {
		return "AppBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AppBean(String string) {
		this.message=string;
	}

}
