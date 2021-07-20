package com.khantwal.points;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.khantwal.points.dto.Offer;
import com.khantwal.points.dto.OfferCategory;
import com.khantwal.points.dto.OfferStatus;
import com.khantwal.points.models.Points;
import com.khantwal.points.repos.PointsRepository;
import com.khantwal.points.services.PointService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PointsApplicationTests {
	
	@Autowired
	private PointService pointService;
	
	@MockBean
	private PointsRepository pointsRepository;

	@Test
	public void getAllEmployeesPointsTest() {
		
		when(pointsRepository.findAll()).thenReturn(Stream
				.of(new Points((long)1,100.00),new Points((long)2,200.00)).collect(Collectors.toList()));
		
		assertEquals(2,pointService.getAllEmployeesPoints().size());
	}
	
	@Test
	public void getPointsOfEmployeeByIdTest() {
		
		long employeeId = 1;
		Points point = new Points((long) 1,100);
		
		when(pointsRepository.existsById(employeeId)).thenReturn(true);
		when(pointsRepository.findByEmployeeId(employeeId)).thenReturn(point);
		
		
		assertEquals(point,pointService.getPointsOfEmployeeById(employeeId));
		assertEquals((double)100, pointService.getPointsOfEmployeeById(employeeId).getPoints(),0);
	}
	
	/*
	 * @Test public void refreshPointsOfEmployeesTest() throws ParseException {
	 * 
	 * long employeeId = 1; OfferStatus offerStatus = new OfferStatus();
	 * offerStatus.setOfferStatusId((long) 1); offerStatus.setLikes((long) 0);
	 * offerStatus.setOfferPostDate(new Date()); offerStatus.setEngagedId((long) 2);
	 * offerStatus.setClosingDate(new
	 * SimpleDateFormat("yyyy-MM-dd").parse("2022-08-09"));
	 * 
	 * OfferCategory category = new OfferCategory();
	 * category.setOfferCategoryId((long) 1); category.setCategoryType("Education");
	 * 
	 * @SuppressWarnings("unused") Offer offer =new Offer((long)
	 * 1,"title 1","content 1",employeeId,offerStatus,category);
	 * 
	 * Points point = new Points((long) 1,100);
	 * 
	 * when(pointsRepository.existsById(employeeId)).thenReturn(true);
	 * when(pointsRepository.findByEmployeeId(employeeId)).thenReturn(point);
	 * when(pointsRepository.save(point)).thenReturn(point);
	 * 
	 * //System.out.println(pointService.refreshPointsOfEmployees(employeeId ,
	 * offer).getPoints());
	 * 
	 * assertNotEquals(100,pointService.refreshPointsOfEmployees(employeeId
	 * ).getPoints());
	 * //assertEquals(200,pointService.refreshPointsOfEmployees(employeeId ,
	 * offer).getPoints()); }
	 */
}
