package com.example.studentmanagementspring.service;

import com.example.studentmanagementspring.*;
import com.example.studentmanagementspring.dto.StudentPatchRequest;
import com.example.studentmanagementspring.dto.StudentRequest;
import com.example.studentmanagementspring.dto.StudentResponse;
import com.example.studentmanagementspring.exception.StudentNotFoundException;
import com.example.studentmanagementspring.mapper.StudentMapper;
import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<StudentResponse> getStudents(Pageable pageable) {
		
		Page<Student> students = studentRepository.findAll(pageable);
		
		return students.map(studentMapper::toResponse);
	}
	
	public Page<StudentResponse> searchByName(String query, Pageable pageable) {
		
		Page<Student> students = studentRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(
				query,
				query,
				pageable
		);
		
		return students.map(studentMapper::toResponse);
	}
	
	public StudentResponse patchUpdateStudentInfoById(
			Integer id,
			StudentPatchRequest patchRequest) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		//grade
		if (patchRequest.getGrade() != null) {
			student.setGrade(patchRequest.getGrade());
		}
		
		//level
		if (patchRequest.getLevel() != null) {
			student.setLevel(patchRequest.getLevel());
		}
		
		//name
		if (patchRequest.getName() != null) {
			student.setName(patchRequest.getName());
		}
		
		//surname
		if (patchRequest.getSurname() != null) {
			student.setSurname(patchRequest.getSurname());
		}
		
		return studentMapper.toResponse(studentRepository.save(student));
	}
}
