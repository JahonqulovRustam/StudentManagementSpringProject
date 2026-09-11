package com.example.studentmanagementspring.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class StudentRequest {
	
	@NotBlank(message = "Name is required")
	@Size(max = 50, message = "Name must be at most 50 characters")
	private String name;
	
	@NotBlank(message = "Surname is required")
	@Size(max = 50, message = "Surname must be at most 50 characters")
	private String surname;
	
	@NotNull(message = "Grade is required")
	@DecimalMin(value = "0.0", message = "Grade must be at least 0")
	@DecimalMax(value = "100.0", message = "Grade must be at most 100")
	private Double grade;
	
	@NotNull(message = "Level is required")
	@Min(value = 1, message = "Level must be at least 1")
	private Integer level;
}
