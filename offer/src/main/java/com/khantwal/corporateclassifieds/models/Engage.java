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
public class Engage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long engageId;
	@Column
	private Long employeeId;
	@Column
	@Temporal(TemporalType.DATE)
	private Date engagedDate = new Date();
	@ManyToOne(targetEntity = Offer.class,cascade = CascadeType.ALL)
	@JsonIgnore
	private Offer offer; 
}
