package com.medicorps.exception;

public class NoContentAvailableException extends RuntimeException{
	
	String errorMsg;

	public NoContentAvailableException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	
}
