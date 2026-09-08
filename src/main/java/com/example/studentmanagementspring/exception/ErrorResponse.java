package com.example.studentmanagementspring.exception;

import lombok.*;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private Integer status;
	private Map<String, String> errors;
	
	public ErrorResponse(String message, Integer status) {
		this.message = message;
		this.status = status;
	}

    public ErrorResponse(String message, Integer status, Map<String, String> errors) {
		
        this.message = message;
        this.status = status;
		this.errors = errors;
    }
	
}
