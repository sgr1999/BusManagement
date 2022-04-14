package com.example.controller;

import com.example.dao.BusBookingRepository;
import com.example.entites.BusBooking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    
    @RequestMapping("/index")
	public String dashbord() {
		
		return "normal/base";
	}

    @RequestMapping("/busDetails")
	public String busDetails() {
		
		return "normal/busDetails";
	}

    

    

}
