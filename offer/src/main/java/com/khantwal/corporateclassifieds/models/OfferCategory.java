package com.khantwal.corporateclassifieds.models;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferCategory { 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long offerCategoryId;
	@Column
	private String categoryType;
//	@OneToMany(targetEntity = Offer.class,mappedBy = "offerCategory", cascade = CascadeType.ALL)
//    private Set<Offer> offer = new HashSet<>();
	@OneToMany(targetEntity = Offer.class, cascade = CascadeType.ALL,mappedBy="offerCategory" , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Offer> offer = new ArrayList<>();  
	  
}
