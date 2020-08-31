package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.JwtRequest;
import com.cts.model.UserDao;
import com.cts.model.UserDto;
import com.cts.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(userservice.saveUserService(user));
	}
	
	@GetMapping("/{pan}")
	public JwtRequest getUserByPan(@PathVariable("pan") String pan) {
		
		JwtRequest response = new JwtRequest();
		UserDao user = userservice.getUserByPan(pan);
		
		response.setPan(user.getPan());
		response.setPassword(user.getPassword());
		
		return response;
	}
	
	@GetMapping("/{pan}/{contact}")
	public boolean verifyUser(@PathVariable String pan, @PathVariable String contact) {
		
		return userservice.verifyUserService(pan, contact);
	}

	
	@RequestMapping("/hello")
	public String hello() {
		return "hii";
	}

}
