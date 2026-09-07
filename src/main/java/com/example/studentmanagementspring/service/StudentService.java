package com.example.studentmanagementspring.service;

import com.example.studentmanagementspring.dto.StudentRequest;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.exception.StudentNotFoundException;
import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	public List<StudentResponse> getAllStudents() {
        
        List<Student> students = studentRepository.findAll();
		List<StudentResponse> studentResponseList = new ArrayList<>();
		for (Student student : students) {
			
			StudentResponse response = new StudentResponse();
			
			response.setId(student.getId());
			response.setName(student.getName());
			response.setSurname(student.getSurname());
			response.setGrade(student.getGrade());
			response.setLevel(student.getLevel());
			
			studentResponseList.add(response);
		}
		
		return studentResponseList;
    }

    public StudentResponse getStudentById(Integer id) {
    
		Student student = new Student();
		
		student = studentRepository.
				findById(id).
				orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		StudentResponse response = new StudentResponse();
		
		response.setId(student.getId());
		response.setName(student.getName());
		response.setSurname(student.getSurname());
		response.setGrade(student.getGrade());
		response.setLevel(student.getLevel());
		
		return response;
	}

    public StudentResponse createStudent(StudentRequest request) {
		
		Student student = new Student();
		
		student.setName(request.getName());
		student.setSurname(request.getSurname());
		student.setGrade(request.getGrade());
		student.setLevel(request.getLevel());
		
		Student savedStudent = studentRepository.save(student);
		
		StudentResponse response = new StudentResponse();
		
		response.setId(savedStudent.getId());
		response.setName(savedStudent.getName());
		response.setSurname(savedStudent.getSurname());
		response.setGrade(savedStudent.getGrade());
		response.setLevel(savedStudent.getLevel());
		
		return response;
    }

    public StudentResponse updateStudentInfoById(Integer id, StudentRequest request) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		student.setName(request.getName());
		student.setSurname(request.getSurname());
		student.setGrade(request.getGrade());
		student.setLevel(request.getLevel());
		
		Student savedStudent = studentRepository.save(student);
		
		StudentResponse response = new StudentResponse();
		
		response.setId(savedStudent.getId());
		response.setName(savedStudent.getName());
		response.setSurname(savedStudent.getSurname());
		response.setGrade(savedStudent.getGrade());
		response.setLevel(savedStudent.getLevel());
		
		return response;
    }

	public void deleteStudentById(Integer id) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		studentRepository.delete(student);
	}

}
