package com.own.proj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerMethod {
	//If a controller method throws an exception while processing an user request, Spring mvc looks for an appropriate exception handler method
	//in this class(with @ControllerAdvice annotation), if it finds, it makes a call to the method. Otherwise it returns a default error page
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class) //Generic exception
	//@ResponseBody
	public String handleException(Exception ex) {
		System.out.println("Unknown exception occured");
		return "Exception";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //It sends a http response code to the browser, ex: 500 error
	@ExceptionHandler(value=NullPointerException.class) //Null Pointer Exception
	public String handleNullPointerException(Exception ex) {
		System.out.println("Null pointer exception occured");
		return "NullPointerException";
	}
}
