package com.email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.Service.service;
import com.email.model.reqConst;

@RestController
public class Controllers {
	@Autowired
	private service emailservice;
	
    @RequestMapping("/welcome")
	public String welcome() {
		return "Hello This is my test emailer";
	}
    @CrossOrigin(origins="http://localhost:3000/")
    @RequestMapping(value="/sendmail",method=RequestMethod.POST)
    public ResponseEntity<?> sendmail(@RequestBody reqConst request){
		//this.emailservice.sendMail(null, null, null);
        System.out.println(request);
        boolean result = this.emailservice.sendMail( request.getSubject(),request.getTo(), request.getMessage());
    	if(result) {
        return ResponseEntity.ok("Message Sent");
		}
    	else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eamil not sent");
    		
    	}
    	}
}
