package com.example.studentmanagementspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class GroupRequest {
	
	@NotBlank(message = "Name is required")
	@Size(max = 50, message = "Name must be at most 50 characters")
	private String name;
}
