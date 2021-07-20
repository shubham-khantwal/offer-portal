package com.khantwal.corporateclassifieds.models;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Likes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long engageId;
	@Column
	private Long employeeId;
	@Column
	private Long offerId;
	@ManyToOne(targetEntity = OfferStatus.class)
	private OfferStatus offerStatus;
}
