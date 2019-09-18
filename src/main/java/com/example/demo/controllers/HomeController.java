package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    @ResponseBody
    public final String home() {
    	if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
	        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
	        logger.info(username);
	        return "Welcome, " + username + SecurityContextHolder.getContext().getAuthentication().getDetails();
    	}
    	return "user is not authenticated";
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> greeting(@RequestHeader("id_token") String user_token) {
        
        return new ResponseEntity<String>("asdadaa", HttpStatus.OK);
    }
    
    

}