package com.simplebootapp.exceptions;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends Exception {

	public InvalidCredentialsException(){
		super("Invalid credentials");
	}

}
