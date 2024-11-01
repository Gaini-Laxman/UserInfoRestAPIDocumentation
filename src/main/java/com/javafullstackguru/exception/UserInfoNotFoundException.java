package com.javafullstackguru.exception;

public class UserInfoNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInfoNotFoundException(String message) {
		super(message);
	}

}
