package com.khantwal.employee.model;

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
public class OfferCategory {
	private Long offerCategoryId;
	private String categoryType;
	private List<Offer> offer;  
}
