package com.khantwal.post.models;

import java.util.List;

import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormData {
	private String title;
	private String content; 
	private Long likes;
	private Long employeeId;  
	private Long offerCategory; 
}
