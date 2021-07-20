package com.khantwal.corporateclassifieds.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long offerStatusId;
	@OneToMany(targetEntity = Likes.class, mappedBy="offerStatus" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Likes> likes;
	@Column
	@Temporal(TemporalType.DATE)
	private Date offerPostDate  = new Date();
	@Column
	@Temporal(TemporalType.DATE)
	private Date closingDate;	
	@OneToOne(targetEntity = Offer.class,mappedBy="offerStatus", cascade = CascadeType.ALL) 
	@JsonIgnore
	private Offer offer;
}
