package com.khantwal.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.khantwal.authentication.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String getAdminPage() {
		LOGGER.info("Inside getAdminPage() of AdminController");
		return "profile";
	}
	
	@RequestMapping(value="/addCategory",method = RequestMethod.POST)
	public String addCategory(@RequestParam("category") String category) {
		LOGGER.info("Inside addCategory() of AdminController");
		adminService.addCategory(category);
		return "msg";
	}
	
	@RequestMapping(value="/refreshPointsOfEmployees",method = RequestMethod.POST)
	public String refreshPointsOfEmployees(@RequestParam("offerId") Long offerId) {
		LOGGER.info("Inside refreshPointsOfEmployees() of AdminController");
		adminService.refreshPointsOfEmployees(offerId);
		return "msg";
	}
	
	
}
