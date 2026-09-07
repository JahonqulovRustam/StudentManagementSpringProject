package com.example.studentmanagementspring.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@JsonPropertyOrder({
		"id",
		"name",
		"surname",
		"grade",
		"level"
})

public class StudentResponse {
	
	private Integer id;
	private String name;
	private String surname;
	private Double grade;
	private Integer level;
	
}
