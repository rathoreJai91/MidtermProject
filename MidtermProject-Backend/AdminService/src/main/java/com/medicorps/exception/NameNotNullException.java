package com.medicorps.exception;

public class NameNotNullException extends RuntimeException{
	
	String errorMsg;
	
	public NameNotNullException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
}
