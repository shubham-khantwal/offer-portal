package com.khantwal.corporateclassifieds.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khantwal.corporateclassifieds.models.Engage;
import com.khantwal.corporateclassifieds.models.Likes;
import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferCategory;
import com.khantwal.corporateclassifieds.models.OfferStatus;
import com.khantwal.corporateclassifieds.repos.EngageRepository;
import com.khantwal.corporateclassifieds.repos.LikesRepository;
import com.khantwal.corporateclassifieds.repos.OfferCategoryRepository;
import com.khantwal.corporateclassifieds.repos.OfferRepository;
import com.khantwal.corporateclassifieds.repos.OfferStatusRepository;

@Service
public class OfferService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferService.class);

	@Autowired
	OfferRepository offerRepository;

	@Autowired
	OfferStatusRepository offerStatusRepository;

	@Autowired
	OfferCategoryRepository offerCategoryRepository;

	@Autowired
	EngageRepository engageRepository;

	@Autowired
	LikesRepository likesRepository;

	public Offer addOffer(Offer offer) {
		LOGGER.info("Inside addOffer() of OfferService");
		OfferCategory cat = offerCategoryRepository.findByCategoryType(offer.getOfferCategory().getCategoryType());
		offer.setOfferCategory(cat);
		Offer off = offerRepository.save(offer);
		off.getOfferStatus().setOffer(off);
		System.out.println(off.getOfferStatus().getOffer().getTitle() + " -- - - - - -- ");
		return off;

	}

	public List<OfferStatus> getAllOfferDetails() {
		LOGGER.info("Inside getAllOfferDetails() of OfferService");
		return offerStatusRepository.findAll();
	}

	public void addCategory(String category) {
		LOGGER.info("Inside addCategory() of OfferService");
		System.out.println("got it");
		OfferCategory cat = new OfferCategory();
		cat.setCategoryType(category);
		offerCategoryRepository.save(cat);
	}

//	public OfferCategory getOfferCategoryObject(String string) {
//		return offerCategoryRepository.findByCategoryType(string);
//	}

//	public void updateOffer(Long offerId, Offer offer) {
//		System.out.println("Inside updateOffer of Service");
//		Offer obj = offerRepository.findById(offerId).get();
//		System.out.println("**************************"+obj);
//		obj.setContent(offer.getContent());
//		obj.setTitle(offer.getTitle());
//		
//		obj.setOfferCategoryId(offer.getOfferCategoryId());
////		OfferCategory offerCategory = obj.getOfferCategory();
////		offerCategory.setCategoryType(offer.getOfferCategory().getCategoryType());
////		obj.setOfferCategory(offerCategory);
//		
//		OfferStatus offerStatus = obj.getOfferStatus();
//		offerStatus.setClosingDate(offer.getOfferStatus().getClosingDate());
//		offerStatus.setLikes(offer.getOfferStatus().getLikes());
//		obj.setOfferStatus(offerStatus);
//		
//		System.out.println(obj);
//		offerRepository.save(obj);
//		
//	
//	}

//	public Offer getOfferDetailsById(Long offerId) {
//		return offerRepository.findById(offerId).get();
//		
//	}

	public List<Offer> getOfferByCategory(String categoryType) {
		LOGGER.info("Inside getOfferByCategory() of OfferService");
		return offerCategoryRepository.findOfferByCategoryType(categoryType);
	}

	public List<Offer> getOfferByEmployeeIdWithLikes(Long employeeId) {
		LOGGER.info("Inside getOfferByEmployeeIdWithLikes() of OfferService");
		return engageRepository.findByEmployeeId(employeeId);

	};

	public void addEngagement(Long employeeId, Long offerId) {
		LOGGER.info("Inside addEngagement() of OfferService");
		Offer off = offerRepository.findById(offerId).get();

		Engage eng = new Engage();
		eng.setEmployeeId(employeeId);
		eng.setOffer(off);
		engageRepository.save(eng);
		off.getEngage().add(eng);

		// List<Engage> lst = offer.getEngage();

//		for(Engage engage : lst) {
//			engage.setOffer(offer);
//			engageRepository.save(engage);
//		}

	}

	public List<Offer> getOfferByEmployeeId(Long employeeId) {
		LOGGER.info("Inside getOfferByEmployeeId() of OfferService");
		List<Offer> res = offerRepository.findByEmployeeId(employeeId);
		return res;
	}

	public List<OfferCategory> getAllCategories() {
		LOGGER.info("Inside getAllCategories() of OfferService");
		return offerCategoryRepository.findAll();
	}

	public List<Offer> getAllOffers() {
		LOGGER.info("Inside getAllOffers() of OfferService");
		return offerRepository.findAll();
	}

	public Offer getOfferDetailsById(Long offerId) {
		LOGGER.info("Inside getOfferDetailsById() of OfferService");
		return offerRepository.findById(offerId).get();
	}

	public OfferStatus getOfferStatusByOfferId(Long offerId) {
		LOGGER.info("Inside getOfferStatusByOfferId() of OfferService");
		return offerRepository.findById(offerId).get().getOfferStatus();
	}

	public String updateLikes(Long employeeId, OfferStatus os, Long offerId) {
		LOGGER.info("Inside updateLikes() of OfferService");

		Likes like = likesRepository.findByEmployeeIdAndOfferId(employeeId, offerId);
		// Offer off = offerRepository.findById(offerId).get();
		// System.out.println(off.getTitle());
		if (like == null) {
//			off.setLikes(off.getLikes()+1);
//			offerRepository.save(off);
			
			 Likes l = new Likes(); 
			 l.setEmployeeId(employeeId); 
			 l.setOfferId(offerId);
			 l.setOfferStatus(os); 
			 likesRepository.save(l);
			 
			System.out.println("No");
			return "saved";

		} else {
//			off.setLikes(off.getLikes()-1);
//			offerRepository.save(off);
			
			 System.out.println(like.getEngageId()+" "+like.getEngageId().getClass()+" "+like.getEmployeeId()); 
			 //like.getOfferStatus().getLikes().remove(like);
			 likesRepository.deleteById(like.getEngageId());
			 
			System.out.println("YES");
			return "likes";
		}

	}

	public void updateLike(int i, Long offerId) {
		LOGGER.info("Inside updateLike() of OfferService");
		Offer off = offerRepository.findById(offerId).get();
		if (i == 1) {
			Long a = off.getLikes();
			// System.out.println(a);
			off.setLikes(a + 1);
			System.out.println(off.getLikes());
		} else {
			Long a = off.getLikes();
			// System.out.println(a);
			if (a >= 1) {
				off.setLikes(a - 1);
			}

			System.out.println(off.getLikes());
		}
		offerRepository.save(off);
	}

//	public List<OfferStatus> getOfferByPostedDate(Date postedDate) {
//		return offerStatusRepository.findByOfferPostDate(postedDate);
////		List<OfferStatus> offerStatus = offerStatusRepository.findByPostedDate();
////		List<Offer> offer = new ArrayList<>();
////		for(OfferStatus os: offerStatus) {
////			offer.add(offerRepository.findByOfferStatusId(os.getOfferStatusId()));
////		}
//		
////		List<Object[]> res = offerRepository.getOfferByPostedDate(postedDate);
////		
////		return res;
//	}

//	public void engageOffer(Long offerId, Long empId) {
//		Engage engage = new Engage();
//		engage.setEmployeeId(empId);
//		engage.setOfferId(offerId);
//		
//		engageRepository.save(engage);
//		
//	}
//
	public List<Offer> getOfferByTopLikes() {
		LOGGER.info("Inside getOfferByTopLikes() of OfferService");
		return offerRepository.sortByLikes();
	}
//
//	public List<Offer> getStatus() {
//		return offerStatusRepository.findOffer();
//	}
//
//	public List<OfferStatus> getListOfOfferStatus() {
//		return offerStatusRepository.findAll();
//	}
//	

	public List<Offer> getOfferByPostedDate() {
		LOGGER.info("Inside getOfferByPostedDate() of OfferService");
		return offerStatusRepository.sortByPostedDate();
	}

	public List<Offer> getOfferByOfferCategoryId(OfferCategory ocId) {
		LOGGER.info("Inside getOfferByOfferCategoryId() of OfferService");
		return offerRepository.findByOfferCategory(ocId);
	}

}
