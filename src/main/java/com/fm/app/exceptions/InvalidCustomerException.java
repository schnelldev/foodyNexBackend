package com.fm.app.exceptions;

public class InvalidCustomerException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidCustomerException() {
		super("Invalid Customer");
	}
}
