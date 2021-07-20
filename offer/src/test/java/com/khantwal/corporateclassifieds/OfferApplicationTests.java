package com.khantwal.corporateclassifieds;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.khantwal.corporateclassifieds.models.Engage;
import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferCategory;
import com.khantwal.corporateclassifieds.models.OfferStatus;
import com.khantwal.corporateclassifieds.repos.EngageRepository;
import com.khantwal.corporateclassifieds.repos.OfferCategoryRepository;
import com.khantwal.corporateclassifieds.repos.OfferRepository;
import com.khantwal.corporateclassifieds.repos.OfferStatusRepository;
import com.khantwal.corporateclassifieds.services.OfferService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OfferApplicationTests {

	@Autowired
	private OfferService offerService;

	@MockBean
	private OfferStatusRepository offerStatusRepository;

	@MockBean
	private OfferRepository offerRepository;

	@MockBean
	private OfferCategoryRepository offerCategoryRepository;

	@MockBean
	private EngageRepository engageRepository;

	OfferStatus offerStatus = new OfferStatus();
	OfferCategory category = new OfferCategory();
	Engage engage = new Engage();
	List<Engage> engageList = new ArrayList<>();
	Offer offer = new Offer();
	List<Offer> offerList = new ArrayList<>();
	long employeeId = 1;

	@Before
	public void init() throws ParseException {

		offerStatus.setOfferStatusId((long) 1);
		// offerStatus.setLikes((long) 0);
		offerStatus.setOfferPostDate(new Date());
		offerStatus.setClosingDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-09"));

		category.setOfferCategoryId((long) 1);
		category.setCategoryType("Education");

		engage.setEmployeeId((long) 1);
		engage.setEngageId((long) 1);
		engage.setEngagedDate(new Date());

		engageList.add(engage);

		offer.setOfferId((long) 1);
		offer.setTitle("title1");
		offer.setContent("Content 1");
		offer.setEmployeeId(employeeId);
		offer.setOfferStatus(offerStatus);
		offer.setEngage(engageList);
		offer.setOfferCategory(category);

		offerStatus.setOffer(offer);
	}

	@Test
	public void getAllOfferDetailsTest() {

		when(offerStatusRepository.findAll()).thenReturn(Stream.of(offerStatus).collect(Collectors.toList()));

		assertEquals(1, offerService.getAllOfferDetails().size());
	}

//	@Test
//	public void addOfferTest() {
//		
//		when(offerCategoryRepository.findByCategoryType("Eduacation"))
//				.thenReturn(category);
//		when(offerRepository.save(offer)).thenReturn(offer);
//		
//		//System.out.println(offer.getOfferCategory().getCategoryType());
//		assertEquals(1,offerService.addOffer(offer).getOfferId());
//	}

//	@Test
//	public void addCategoryTest() {
//		
//		when(offerCategoryRepository.save(category)).thenReturn(category);
//		
//		assertTrue(offerService.addCategory(category.getCategoryType()));
//		
//	}

	@Test
	public void getOfferByCategoryTest() {

		List<Offer> offerList = new ArrayList<>();
		offerList.add(offer);

		when(offerCategoryRepository.findOfferByCategoryType(category.getCategoryType())).thenReturn(offerList);

		assertEquals(1, offerService.getOfferByCategory(category.getCategoryType()).size());
	}

	@Test
	public void getOfferByEmployeeIdTest() {

		offerList.add(offer);

		when(offerRepository.findByEmployeeId(employeeId)).thenReturn(offerList);

		assertEquals(1, offerService.getOfferByEmployeeId(employeeId).size());
	}

	@Test
	public void getOfferByEmployeeIdWithLikesTest() {

		offerList.add(offer);

		when(engageRepository.findByEmployeeId(employeeId)).thenReturn(offerList);

		assertEquals(1, offerService.getOfferByEmployeeIdWithLikes(employeeId).size());
	}
}
