package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class MailValidation extends Exception {

	public MailValidation(String message) {
		super(message);
	}	
}


