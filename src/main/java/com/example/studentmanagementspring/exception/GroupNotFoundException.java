package com.example.studentmanagementspring.exception;

public class GroupNotFoundException extends RuntimeException {
	public GroupNotFoundException(String message) {
		super(message);
	}
}
