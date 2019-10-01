package com.simplebootapp.exceptions;

public class DatabaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DatabaseException()
	{
		super("Database Error");
	}
}
