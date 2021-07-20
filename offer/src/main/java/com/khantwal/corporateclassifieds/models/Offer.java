package com.khantwal.corporateclassifieds.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long offerId;
	@Column
	@NotNull
	private String title;
	@Column
	private Long likes;
	@Lob
	@Column 
	@NotNull
	private String content; 
	@Column
	private Long employeeId;   
	@OneToOne(targetEntity = OfferStatus.class, cascade = CascadeType.ALL)
	private OfferStatus offerStatus;
	@ManyToOne(targetEntity = OfferCategory.class,cascade = CascadeType.ALL)
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private OfferCategory offerCategory; 
	@OneToMany(targetEntity = Engage.class,mappedBy="offer",cascade = CascadeType.ALL)
	private List<Engage> engage;
}
