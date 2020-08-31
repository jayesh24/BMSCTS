package com.cts.service;

import org.springframework.stereotype.Service;

import com.cts.model.UserDao;
import com.cts.model.UserDto;

@Service
public interface UserService {
	
	public UserDao saveUserService(UserDto userDto)throws Exception;

	public UserDao  getUserByPan(String pan);
	
	public boolean verifyUserService(String pan, String contact);

}
