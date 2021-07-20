package com.khantwal.points.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khantwal.points.controllers.PointsController;
import com.khantwal.points.dto.Offer;
import com.khantwal.points.models.Points;
import com.khantwal.points.repos.PointsRepository;

@Service
public class PointService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PointService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PointsRepository pointsRepository;
	
	public List<Points> getAllEmployeesPoints() {
		LOGGER.info("Inside getAllEmployeesPoints() of PointService");
		return pointsRepository.findAll();
	}
	
	public Points savePoints(Points points) {
		LOGGER.info("Inside savePoints() of PointService");
		return pointsRepository.save(points);
	}
	public Points getPointsOfEmployeeById(Long employeeId) {
		LOGGER.info("Inside getPointsOfEmployeeById() of PointService");
		System.out.println(pointsRepository.existsById(employeeId));
		Points points = null;
		
		if (pointsRepository.existsById(employeeId)) {
			points = pointsRepository.findByEmployeeId(employeeId);
			return points;
		}
		else {
			Points p = new Points(employeeId,0);
			points = savePoints(p);
			System.out.println("inside else" + points);
			return points;
		}
		
	}

	public Points refreshPointsOfEmployees(Long offerId) {
		LOGGER.info("Inside refreshPointsOfEmployees() of PointService");
		Offer offer = restTemplate
				.getForObject("http://OFFER-SERVICE/offer/getOfferDetails/"+offerId,Offer.class);
		Long employeeId = offer.getEmployeeId(); 
		
		
		Long likes = offer.getOfferStatus().getLikes();
		Points p = getPointsOfEmployeeById(employeeId);
		double points = p.getPoints();
		
		Date current = new Date();
		
		LocalDate temp = LocalDate.parse("8-Jul-2021", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
		Date offerStartDate = Date.from(temp.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		LocalDate temp2 = LocalDate.parse("9-Jul-2021", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
		Date engageDate = Date.from(temp2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		//Date offerStartDate = offer.getOfferStatus().getOfferPostDate();
		 
		//Date engageDate = offer.getOfferStatus().getEngagedId().getEngageDate();
		
		long time1 = current.getTime() - offerStartDate.getTime();
		long daysSinceOfferPosted= (time1 / (1000 * 60 * 60 * 24)) % 365;
        
		long time2 = engageDate.getTime() - offerStartDate.getTime();
		long daysInEngaging= (time2 / (1000 * 60 * 60 * 24)) % 365;
         
		 if(likes>50 && daysSinceOfferPosted<=2)	
			 points+=10;
		 else if(likes>100 && daysSinceOfferPosted<=2)	
			  points+=50;
		 else if(daysInEngaging<=2)	
			 points+=100;
		 
		 p.setPoints(points);
		 return savePoints(p);
		
	}

}
