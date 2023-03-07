package com.medicorps.exception;

public class IdNotFoundException extends RuntimeException {

	String errorMsg;

	public IdNotFoundException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	
}
