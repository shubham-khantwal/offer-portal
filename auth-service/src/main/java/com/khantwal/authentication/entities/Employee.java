package com.khantwal.authentication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Long employeeId;

	private String name;

	private String ph;

	private String email;

	private String password;

	private String role;

}
