package com.khantwal.employee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
	private Long offerId;
	private String title;
	private String content; 
	private Long likes;
	private Long employeeId;  
	@Embedded
	private OfferStatus offerStatus;
	@Embedded
	private OfferCategory offerCategory; 
	@Embedded
	private List<Engage> engage;
}
