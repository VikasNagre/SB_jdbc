package com.example.jdbcProject;

public class BadPersonRequestException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
//	String applicationStatusCode;
	public BadPersonRequestException(String message) {
		super(message);
	}
	
}
