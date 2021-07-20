package com.khantwal.employee.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khantwal.employee.controller.EmployeeController;
import com.khantwal.employee.model.Employee;
import com.khantwal.employee.model.Offer;
import com.khantwal.employee.model.OfferStatus;
import com.khantwal.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RestTemplate restTemplate;

	public Employee viewProfile(Long employeeId) {
		LOGGER.info("Inside viewProfile() of EmployeeService");
		return employeeRepository.findById(employeeId).get();
	}

	public OfferStatus[] mostLikedOffers(Long employeeId) {
		LOGGER.info("Inside mostLikedOffers() of EmployeeService");
		OfferStatus[] offer = restTemplate.getForObject(
				"http://OFFER-SERVICE/offer/getOfferByEmployeeIdWithLikes/" + employeeId, OfferStatus[].class);

		return offer;
	}

	public Offer[] viewEmployeeOffers(Long employeeId) {
		LOGGER.info("Inside viewEmployeeOffers() of EmployeeService");
		Offer[] offer = restTemplate.getForObject("http://OFFER-SERVICE/offer/getOfferByEmployeeId/" + employeeId,
				Offer[].class);

		return offer;
	}

	public Employee registerEmployee(Employee employee) {
		LOGGER.info("Inside registerEmployee() of EmployeeService");
		return employeeRepository.save(employee);
	}

	public Employee findByEmailAndPassword(String email, String password) {
		LOGGER.info("Inside findByEmailAndPassword() of EmployeeService");
		return employeeRepository.findByEmailAndPassword(email,password);
	}

	public Employee getEmployeeByUserName(String username) {
		LOGGER.info("Inside getEmployeeByUserName() of EmployeeService");
		return employeeRepository.findByEmail(username);
	}

}
