package com.simplebootapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InterruptedException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String employeeNotFoundHandler(InterruptedException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String invalidCredentialsHandler(InvalidCredentialsException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(JwtException.class)
	String signatureHandler(JwtException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DatabaseException.class)
	String signatureHandler(DatabaseException ex) {
		return ex.getMessage();
	}

}