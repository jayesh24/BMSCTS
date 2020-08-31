package com.cts.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

	@ControllerAdvice
	@RestController
	public class CustomException extends ResponseEntityExceptionHandler {  
		

		@ExceptionHandler(UserAlreadyExist.class)
		public final ResponseEntity<Object> userNotFoundException
									(Exception ex, WebRequest request) throws Exception {
			
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
			return new ResponseEntity(exceptionResponse, HttpStatus.CONFLICT);
		
		}
		
		@ExceptionHandler(ContactNoInvalid.class)
		public final ResponseEntity<Object> contactNoInvalid
									(Exception ex, WebRequest request) throws Exception {
			
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
		}
		
		@ExceptionHandler(InvalidPanNo.class)
		public final ResponseEntity<Object> invalidPanNo
									(Exception ex, WebRequest request) throws Exception {
			
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
		}
		
		@ExceptionHandler(MailValidation.class)
		public final ResponseEntity<Object> mailValidation
									(Exception ex, WebRequest request) throws Exception {
			
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
		}



}
