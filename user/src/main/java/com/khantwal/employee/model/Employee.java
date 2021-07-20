package com.khantwal.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@NotBlank(message="Please Enter Your Name.")
	private String name;
	@Column(unique=true)
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
	private String ph;
	@NotBlank(message = "Enter Your Email")
	@Column(unique=true)
	private String email;
	@Column
	@NotBlank(message = "Enter Your Password")
	private String password;
	@Column
	private String role;
	
}
