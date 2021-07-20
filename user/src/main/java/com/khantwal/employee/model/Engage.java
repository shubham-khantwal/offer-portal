package com.khantwal.employee.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Component
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
