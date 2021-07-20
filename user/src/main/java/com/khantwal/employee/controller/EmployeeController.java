package com.khantwal.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khantwal.employee.model.Employee;
import com.khantwal.employee.model.Offer;
import com.khantwal.employee.model.OfferStatus;
import com.khantwal.employee.service.EmployeeService;
@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/viewProfile/{employeeId}")
	public Employee viewProfile(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Inside viewProfile() of EmployeeController");
		return employeeService.viewProfile(employeeId);
	}
	
	@GetMapping("/getEmployeeByUserName/{username}")
	public Employee getEmployeeByUserName(@PathVariable("username") String username) {
		LOGGER.info("Inside getEmployeeByUserName() of EmployeeController");
		return employeeService.getEmployeeByUserName(username);
	}
	
	
	@GetMapping("/mostLikedOffers/employeeId}")
	public OfferStatus[] mostLikedOffers(@PathVariable("employeeId") Long employeeId){
		LOGGER.info("Inside mostLikedOffers() of EmployeeController");
		return employeeService.mostLikedOffers(employeeId);
	}
	
	@GetMapping("/viewEmployeeOffers/{employeeId}")
	public Offer[] viewEmployeeOffers(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Inside viewEmployeeOffers() of EmployeeController");
		return employeeService.viewEmployeeOffers(employeeId);
	}

	@PostMapping("/registerEmployee")
	public Employee registerEmployee(@RequestBody Employee employee) {
		LOGGER.info("Inside registerEmployee() of EmployeeController");
		return employeeService.registerEmployee(employee);
	}
	
	@GetMapping("/findByEmailAndPassword/{email}/{password}")
	public Employee findByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
		LOGGER.info("Inside findByEmailAndPassword() of EmployeeController");
		return employeeService.findByEmailAndPassword(email,password);
	}
	
	@PostMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		LOGGER.info("Inside updateEmployee() of EmployeeController");
		return employeeService.registerEmployee(employee);
	}
}
