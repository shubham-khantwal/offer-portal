package com.khantwal.corporateclassifieds.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferCategory;
import com.khantwal.corporateclassifieds.models.OfferStatus;
import com.khantwal.corporateclassifieds.services.OfferService;


@RequestMapping("/offer")
@RestController
@CrossOrigin
public class OfferController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferController.class);
	
	@Autowired
	OfferService offerService;
	
	@GetMapping("/getAllOfferDetails")
	public List<OfferStatus> getAllOfferDetails(){
		LOGGER.info("Inside getAllOfferDetails() of OfferController");
		return offerService.getAllOfferDetails();
	}
	
	@GetMapping("/getAllOffers")
	public List<Offer> getAllOffers(){
		LOGGER.info("Inside getAllOffers() of OfferController");
		return offerService.getAllOffers();
	}
	
	@GetMapping("/getAllCatories")
	public List<OfferCategory> getAllCategories(){
		LOGGER.info("Inside getAllCategories() of OfferController");
		return offerService.getAllCategories();
	}
	
	@GetMapping("/getOfferDetails/{offerId}")
	public Offer getOfferDetialsById(@PathVariable("offerId") Long offerId) {
		LOGGER.info("Inside getOfferDetialsById() of OfferController");
		return offerService.getOfferDetailsById(offerId);
	}
	
	
	@PostMapping("/addoffer")
	public Offer addOffer(@RequestBody Offer offer ) {
		LOGGER.info("Inside addOffer() of OfferController");
		return offerService.addOffer(offer);		
	}
	
	@PostMapping("/addCategory/{category}")
	public void addCategory(@PathVariable("category") String category) {
		LOGGER.info("Inside addCategory() of OfferController");
		System.out.println(category);
		offerService.addCategory(category);
	}
	
//	@PutMapping("/updateOffer/{offerId}")
//	public void updateOffer(@RequestBody Offer offer , @PathVariable("offerId") Long offerId) {
//		System.out.println("inside updateOffer Controller");
//		offerService.updateOffer(offerId,offer);
//	}
	
	@GetMapping("/getOfferByCategory/{categoryType}")
	public List<Offer> getOfferByCategory(@PathVariable("categoryType") String categoryType){
		LOGGER.info("Inside getOfferByCategory() of OfferController");
		List<Offer> res = offerService.getOfferByCategory(categoryType);
//		OfferCategory ocId = offerService.getOfferByCategory(categoryType);
//		List<Offer>res = offerService.getOfferByOfferCategoryId(ocId);
//		for(Offer off : res) {
//			System.out.println(off.getOfferStatus().getLikes());
//		}
		return res;
	} 
	
//	@GetMapping("/getOfferByPostedDate/{postedDate}")
//	public List<OfferStatus> getOfferByPostedDate(@PathVariable("postedDate") String postedDate){
//		//Date date = new Date(postedDate);
//		System.out.println(postedDate+" "+postedDate.getClass());
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(postedDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(date+" "+date.getClass());
//		return offerService.getOfferByPostedDate(date);
//	}
//	
//	
//	@PostMapping("/engageOffer/{offerId}/{empId}")
//	public void engageOffer(@PathVariable("offerId") Long offerId,@PathVariable("empId") Long empId) {
//		offerService.engageOffer(offerId,empId);
//	}
	
	@GetMapping("/getOfferByLikes")
	public List<Offer> getOfferByLikes() {
		LOGGER.info("Inside getOfferByLikes() of OfferController");
		return offerService.getOfferByTopLikes();
		
	}
//	
//	@GetMapping("/getListOfOfferStatus")
//	public List<OfferStatus> getListOfOfferStatus(){
//		
//		return offerService.getListOfOfferStatus();
//	}
//	
	@GetMapping("/getOfferByPostedDate")
	public List<Offer> getOfferByPostedDate(){
		LOGGER.info("Inside getOfferByPostedDate() of OfferController");
		return offerService.getOfferByPostedDate();
	}
	
	@GetMapping("/addEngagement/{employeeId}/{offerId}")
	public Offer addEngagement(@PathVariable("employeeId") Long employeeId , @PathVariable Long offerId) {
		LOGGER.info("Inside addEngagement() of OfferController");
		offerService.addEngagement(employeeId , offerId);
		return getOfferDetialsById(offerId);
	}
	
	@GetMapping("/getOfferByEmployeeIdWithLikes/{employeeId}")
	public List<Offer> getOfferByEmployeeIdWithLikes(@PathVariable("employeeId") Long employeeId){
		LOGGER.info("Inside getOfferByEmployeeIdWithLikes() of OfferController");
		return offerService.getOfferByEmployeeIdWithLikes(employeeId);
	} 
	
	@GetMapping("/getOfferByEmployeeId/{employeeId}")
	public List<Offer> getOfferByEmployeeId(@PathVariable("employeeId") Long employeeId){
		LOGGER.info("Inside getOfferByEmployeeId() of OfferController");
		List<Offer> res = offerService.getOfferByEmployeeId(employeeId);
//		for(Offer off : res) {
//		System.out.println(off.getOfferStatus().getLikes());
//	}
		return res;
	} 
	
	public OfferStatus getOfferStatusByOfferId(Long offerId) {
		LOGGER.info("Inside getOfferStatusByOfferId() of OfferController");
		return offerService.getOfferStatusByOfferId(offerId);
	}
	
	@GetMapping("/updateLikes/{employeeId}/{offerId}")
	public String updateLikes(@PathVariable("employeeId") Long employeeId , @PathVariable("offerId") Long offerId) {
		LOGGER.info("Inside updateLikes() of OfferController");
		OfferStatus os = getOfferStatusByOfferId(offerId);
		System.out.println(os.getOfferStatusId());
		//return "saved";
		String s = offerService.updateLikes(employeeId,os,offerId);
		if(s.equals("saved")) {
		System.out.println("YES inc");
		updateLike(1 , offerId);
		return "saved";
		}
		else {
		System.out.println("NO Dec");

    	updateLike(-1 , offerId);
    	return "likes";
		}
		
	}

	private void updateLike(int i , Long offerId) {
		LOGGER.info("Inside updateLike() of OfferController");
		offerService.updateLike(i, offerId);
	}
	
}
