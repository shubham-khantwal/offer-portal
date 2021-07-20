package com.khantwal.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OfferStatus {
	private Long offerStatusId;
	private List<Likes> likes;
	private Date offerPostDate;
	private Long engagedId;
	private Date closingDate;
	private Offer offer;
}
