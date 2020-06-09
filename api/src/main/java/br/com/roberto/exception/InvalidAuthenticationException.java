package br.com.roberto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAuthenticationException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	
	public InvalidAuthenticationException(String exception) {
		super(exception);
	}

}
