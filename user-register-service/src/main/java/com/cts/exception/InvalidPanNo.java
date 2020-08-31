package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidPanNo extends Exception {

	public InvalidPanNo(String message) {
		super(message);
	}
}

