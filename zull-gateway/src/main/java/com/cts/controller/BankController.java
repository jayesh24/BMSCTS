package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.UserClient;
import com.cts.jwt.model.JwtRequest;

@RestController
public class BankController {
	
    @RequestMapping({ "/welcome" })
    public String welcomePage() {
        return "Welcome Page";
    }
    
    @Autowired
    UserClient userClient;
    
    @RequestMapping("/register/{pan}")
    public JwtRequest getPan(@PathVariable String pan) {
    	JwtRequest jwtRequest = userClient.getUserByPan(pan);
    	return jwtRequest;
    }
}