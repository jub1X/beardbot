package com.beard.exceptions;

public class BeardRunTimeException extends Exception {

	private static final long serialVersionUID = 7575316898691578300L;
	
	public BeardRunTimeException(String message) {
		super(message);
	}
	
	public BeardRunTimeException(Throwable cause) {
		super(cause);
	}
	public BeardRunTimeException(String message,Throwable cause) {
		super(message, cause);
	}

}
