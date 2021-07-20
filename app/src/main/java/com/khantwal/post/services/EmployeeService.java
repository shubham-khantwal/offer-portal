package com.khantwal.post.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khantwal.post.models.Employee;
import com.khantwal.post.models.Offer;
import com.khantwal.post.models.OfferCategory;
import com.khantwal.post.models.Points;


@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	public void registerEmployee(Employee employee) {
		LOGGER.info("Inside registerEmployee() of EmployeeService");
		Employee emp = restTemplate
				.postForObject("http://AUTHENTICATION-SERVICE/auth/registerEmployee/",employee,Employee.class);
		System.out.println(emp);
	}

	public Employee findByEmailAndPassword(String email, String password) {
		LOGGER.info("Inside findByEmailAndPassword() of EmployeeService");
		Employee emp = restTemplate
				.getForObject("http://EMPLOYEE-SERVICE/employee/findByEmailAndPassword/"+email+"/"+password, Employee.class);
		return emp;
	}

	public void updateEmployee(Employee employee) {
		LOGGER.info("Inside updateEmployee() of EmployeeService");
		Employee emp = restTemplate
				.postForObject("http://EMPLOYEE-SERVICE/employee/updateEmployee/",employee,Employee.class);
		System.out.println(emp);
	}

	public List<OfferCategory> getAllCategories() {
		LOGGER.info("Inside getAllCategories() of EmployeeService");
		OfferCategory[] off = restTemplate
				.getForObject("http://OFFER-SERVICE/offer/getAllCatories/",  OfferCategory[].class);
		List<OfferCategory> offerCat = Arrays.asList(off);
		return offerCat;
	}


	public void savePost(Offer offer) {
		LOGGER.info("Inside savePost() of EmployeeService");
		Offer off = restTemplate
				.postForObject("http://OFFER-SERVICE/offer/addoffer/", offer,Offer.class);
		System.out.println(off.getContent()+" from my blogs");
	}

	public List<Offer> getOfferOfEmployee(Long employeeId) {
		LOGGER.info("Inside getOfferOfEmployee() of EmployeeService");
		Offer[] off = restTemplate
				.getForObject("http://OFFER-SERVICE/offer/getOfferByEmployeeId/"+employeeId,  Offer[].class);
		List<Offer> offer = Arrays.asList(off);
		return offer;
	}

//	public List<Offer> getAllOffers() {
//		Offer[] off = restTemplate
//				.getForObject("http://OFFER-SERVICE/offer/getAllOffers/",  Offer[].class);
//		List<Offer> offer = Arrays.asList(off);
//		return offer;
//	}

	public Offer getOffer(Long offerId) {
		LOGGER.info("Inside getOffer() of EmployeeService");
		Offer off = restTemplate
				.getForObject("http://OFFER-SERVICE/offer/getOfferDetails/"+offerId,  Offer.class);
		return off;
	}

	public void addEngagement(Long employeeId, Long offerId) {
		LOGGER.info("Inside addEngagement() of EmployeeService");
		restTemplate
				.getForObject("http://OFFER-SERVICE/offer/addEngagement/"+employeeId+"/"+offerId,Offer.class);
	}

	public String updateLikes(Long employeeId, Long offerId) {
		LOGGER.info("Inside updateLikes() of EmployeeService");
		
		String res = restTemplate
				.getForObject("http://OFFER-SERVICE/offer/updateLikes/"+employeeId+"/"+offerId,String.class);
		
		return res;
	}

	public Points getPoints(Long employeeId) {
		LOGGER.info("Inside getPoints() of EmployeeService");
		Points pts = restTemplate
		.getForObject("http://POINT-SERVICE/points/getPointsOfEmployee/"+employeeId,Points.class);
		System.out.println(pts.getPoints());
		return pts;
	}

	public List<Offer> getOffers(String sortBy) {
		LOGGER.info("Inside getOffers() of EmployeeService");
		List<Offer> off = null;
		if(sortBy.equals("all")) { 
			off = Arrays.asList( restTemplate
					.getForObject("http://OFFER-SERVICE/offer/getAllOffers/",  Offer[].class));
		}
		else if(sortBy.equals("likes")) {
			off = Arrays.asList( restTemplate
					.getForObject("http://OFFER-SERVICE/offer/getOfferByLikes/",  Offer[].class));
		}else if( sortBy.equals("date") ) {
			System.out.println("INSIDE getOfferByCategory");
			off = Arrays.asList( restTemplate
					.getForObject("http://OFFER-SERVICE/offer/getOfferByPostedDate/",  Offer[].class));
			System.out.println("INSIDE getOfferByCategorydd");
		}else {
			off = Arrays.asList( restTemplate
					.getForObject("http://OFFER-SERVICE/offer/getOfferByCategory/"+sortBy,  Offer[].class));
		}
		return off;
	}

	public String getAdminPage() {
		LOGGER.info("Inside getAdminPage() of EmployeeService");
		return restTemplate
		.getForObject("http://AUTHENTICATION-SERVICE/auth/admin/",  String.class);
	}
	
	
	
}
