package com.khantwal.points.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khantwal.points.dto.Offer;
import com.khantwal.points.models.Points;
import com.khantwal.points.services.PointService;

@RestController
@RequestMapping("/points")
public class PointsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PointsController.class);

	@Autowired
	private PointService pointService;
	
	@GetMapping("/getAllEmployeesPoints")
	public List<Points> getAllEmployeesPoints() {
		LOGGER.info("Inside getAllEmployeesPoints() of PointsController");
		return pointService.getAllEmployeesPoints();
	}
	
	@GetMapping("/getPointsOfEmployee/{employeeId}")
	public Points getPointsOfEmployeeById(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Inside getPointsOfEmployeeById() of PointsController");
        return pointService.getPointsOfEmployeeById(employeeId);
	}
	
	
	
	@PostMapping("/refreshPointsOfEmployees/{offerId}")
	public Points refreshPointsOfEmployees(@PathVariable("offerId") Long offerId ) {
		LOGGER.info("Inside refreshPointsOfEmployees() of PointsController");
		  return pointService.refreshPointsOfEmployees(offerId);
		   
	}

}
