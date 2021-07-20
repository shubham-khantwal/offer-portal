package com.khantwal.points.dto;

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
	private Long employeeId;  
	@Embedded
	private OfferStatus offerStatus;
	@Embedded
	private OfferCategory offerCategory;
}
