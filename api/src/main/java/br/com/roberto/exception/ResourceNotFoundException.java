package br.com.roberto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends AuthenticationException{


	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}
