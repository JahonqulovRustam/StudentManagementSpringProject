package com.example.studentmanagementspring.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@JsonPropertyOrder({
		"id",
		"name"
})

public class GroupResponse {
	private Integer id;
	private String name;
}
