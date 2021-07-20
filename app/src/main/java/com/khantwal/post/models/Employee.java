package com.khantwal.post.models;


import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Long employeeId;
	private String name;
	private Long ph;
	private String email;
	private String password;
	private String role;
	
}
