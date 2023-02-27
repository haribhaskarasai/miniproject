package com.stg.exception;

public class ExceptionClass extends RuntimeException {
	
	public ExceptionClass() {
	}

	private String message;

	public ExceptionClass(String message) {

		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
