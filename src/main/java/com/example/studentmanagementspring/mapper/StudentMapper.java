package com.example.studentmanagementspring.mapper;

import com.example.studentmanagementspring.dto.GroupResponse;
import com.example.studentmanagementspring.dto.StudentRequest;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.model.*;
import com.example.studentmanagementspring.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
	
	public StudentResponse toResponse(Student student) {
		StudentResponse response = new StudentResponse();
		
		response.setId(student.getId());
		response.setName(student.getName());
		response.setSurname(student.getSurname());
		response.setGrade(student.getGrade());
		response.setLevel(student.getLevel());
		response.setGroup(toGroupResponse(student.getGroup()));
		
		return response;
	}
	
	public Student toEntity(StudentRequest request) {
		Student student = new Student();
		
		student.setName(request.getName());
		student.setSurname(request.getSurname());
		student.setGrade(request.getGrade());
		student.setLevel(request.getLevel());
		
		return student;
	}
	
	public void updateEntity(Student student, StudentRequest request) {
		
		student.setName(request.getName());
		student.setSurname(request.getSurname());
		student.setGrade(request.getGrade());
		student.setLevel(request.getLevel());
	}
	
	public GroupResponse toGroupResponse(Group group) {
		
		GroupResponse groupResponse = new GroupResponse();
		groupResponse.setId(group.getId());
		groupResponse.setName(group.getName());
		
		return groupResponse;
	}
}
