package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.exception.ContactNoInvalid;
import com.cts.exception.InvalidPanNo;
import com.cts.exception.MailValidation;
import com.cts.exception.UserAlreadyExist;
import com.cts.model.UserDao;
import com.cts.model.UserDto;
import com.cts.repository.UserRepository;
import com.cts.validation.Validation;

@Service
public class UserserviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private Validation validation;
	
	public UserDao saveUserService(UserDto userDto) throws UserAlreadyExist, ContactNoInvalid, InvalidPanNo, MailValidation  {
		
		String pan = userDto.getPan().toUpperCase();
		UserDao check = userRepository.findByPan(pan);
		
		UserDao user = new UserDao();
		
		if(check!=null)
			throw new UserAlreadyExist("user with username "+pan+" already exist");
		
		
		else {
			
		user.setName(userDto.getName());
		user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
		
		
		// PAN VALIDATION
		if(validation.panValidation(pan)==true)
			user.setPan(pan);
		else
			throw new InvalidPanNo("please provide pan in format => HHBPK5420C");
		
		
		// CONTACT NO VALIDATION
		if(validation.contactValidation(userDto.getContact())==true)
			user.setContact(userDto.getContact());
		else 
			throw new ContactNoInvalid("please provide valid contact no");
		
		
		// MAIL VALIDATION
		if(validation.mailValidation(userDto.getMailId())==true)
			user.setMailId(userDto.getMailId());
		else
			throw new MailValidation("please provide correct format of mail id");
		
		
		userRepository.save(user);
		
		return user;
		
		}

	}

	@Override
	public UserDao getUserByPan(String pan) {
		return userRepository.findByPan(pan);
	}

	@Override
	public boolean verifyUserService(String pan, String contact) {
		
		UserDao user = userRepository.findByPan(pan);
		
		if(user != null) {
			if(contact.equals(user.getContact())) return true;
		}
		
		return false;
	}
	
}
