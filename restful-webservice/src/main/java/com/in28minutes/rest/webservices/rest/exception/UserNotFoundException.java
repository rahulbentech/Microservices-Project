package com.in28minutes.rest.webservices.rest.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4497463402079276348L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
