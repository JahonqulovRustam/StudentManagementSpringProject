package com.example.studentmanagementspring.service;

import com.example.studentmanagementspring.dto.StudentRequest;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.exception.StudentNotFoundException;
import com.example.studentmanagementspring.mapper.StudentMapper;
import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;
	
	public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
		this.studentRepository = studentRepository;
		this.studentMapper = studentMapper;
	}
	
	
	public List<StudentResponse> getAllStudents() {
        
        List<Student> students = studentRepository.findAll();
		List<StudentResponse> studentResponseList = new ArrayList<>();
		
		for (Student student : students) {
			
			studentResponseList.add(studentMapper.toResponse(student));
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
		
		return studentMapper.toResponse(student);
	}

    public StudentResponse createStudent(StudentRequest request) {
		
		return studentMapper.toResponse(
				studentRepository.save(
						studentMapper.toEntity(request)
				)
		);
    }

    public StudentResponse updateStudentInfoById(Integer id, StudentRequest request) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		studentMapper.updateEntity(student, request);
		
		Student savedStudent = studentRepository.save(student);
		
		return studentMapper.toResponse(savedStudent);
    }

	public void deleteStudentById(Integer id) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		studentRepository.delete(student);
	}

}
