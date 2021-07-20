package com.khantwal.points.dto;

import java.util.Date;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferStatus {
	private Long offerStatusId;
	private Long likes;
	private Date offerPostDate;
	private Long engagedId;
	private Date closingDate;
	private Offer offer;
}
