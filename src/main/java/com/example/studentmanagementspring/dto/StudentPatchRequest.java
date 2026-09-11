package com.example.studentmanagementspring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class StudentPatchRequest {
	
	@Size(min = 1, max = 50,
		    message = "Name must be between 1 and 50 characters")
	@Pattern(
			regexp = "^(?!\\s*$).+",
			message = "Name cannot be empty or consist only of spaces"
	)
	private String name;
	
	@Size(min = 1, max = 50,
			message = "Surname must be between 1 and 50 characters")
	@Pattern(
			regexp = "^(?!\\s*$).+",
			message = "Surname cannot be empty or consist only of spaces")
	private String surname;
	
	@DecimalMin(value = "0.0", message = "Grade must be at least 0")
	@DecimalMax(value = "100.0", message = "Grade must be at most 100")
	private Double grade;
	
	@Min(value = 1, message = "Level must be at least 1")
	private Integer level;
}
