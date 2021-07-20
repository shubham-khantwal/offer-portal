package com.khantwal.authentication.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khantwal.authentication.entities.Offer;

@Service
public class AdminService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	RestTemplate restTemplate;
	
	public void addCategory(String category) {
		LOGGER.info("Inside addCategory() of AdminService");

		restTemplate
		.getForObject("http://OFFER-SERVICE/offer/addCategory/"+category,Offer.class);
	}


	public void refreshPointsOfEmployees(Long offerId) {
		LOGGER.info("Inside refreshPointsOfEmployees() of AdminService");
		restTemplate
		.getForObject("http://POINT-SERVICE/points/refreshPointsOfEmployees/"+offerId,Offer.class);
	}

}
