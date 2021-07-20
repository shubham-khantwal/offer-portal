package com.khantwal.authentication.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
