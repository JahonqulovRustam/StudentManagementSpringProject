package com.example.studentmanagementspring.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class GroupPatchRequest {
	
	@Size(min = 1, max = 50,
			message = "Name must be between 1 and 50 characters")
	@Pattern(
			regexp = "^(?!\\s*$).+",
			message = "Name cannot be empty or consist only of spaces"
	)
	private String name;
}
