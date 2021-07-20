package com.khantwal.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khantwal.authentication.entities.Employee;
import com.khantwal.authentication.services.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/registerEmployee", method = RequestMethod.POST)
	public Employee registerEmployee(@RequestBody Employee employee) {
		LOGGER.info("Inside registerEmployee() of AuthController");
		return authService.registerEmployee(employee);
	}
	
}
