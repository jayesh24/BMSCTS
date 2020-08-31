package com.cts.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validation {
	
	public boolean contactValidation(String no) {
		
		 Pattern p = Pattern.compile("[7-9][0-9]{9}");
	     Matcher m = p.matcher(no);
	     return m.matches();
	}
	
	public boolean panValidation(String pan) {
		
		Pattern p = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]");
		Matcher m = p.matcher(pan);
		return m.matches();
	}

	public boolean mailValidation(String mailId) {
		
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
		Matcher m = p.matcher(mailId);
		return m.matches();
	}

}
