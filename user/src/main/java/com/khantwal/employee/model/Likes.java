package com.khantwal.employee.model;

import java.util.Date;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
	private Long engageId;
	private Long employeeId;
	private Long offerId;
	private OfferStatus offerStatus;
}
