package com.khantwal.post.models;



import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engage {
	private Long engageId;
	private Long employeeId;
	private Date engagedDate;
	@Embedded
	private Offer offer;
}