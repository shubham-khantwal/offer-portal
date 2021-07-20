package com.khantwal.authentication.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khantwal.authentication.entities.Employee;

@Service
public class AuthService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Employee registerEmployee(Employee employee) {
		LOGGER.info("Inside registerEmployee() of AuthService");
		employee.setPassword(employee.getPassword());
		Employee emp = restTemplate
				.postForObject("http://EMPLOYEE-SERVICE/employee/registerEmployee/",employee,Employee.class);
		return emp;
	}

}
