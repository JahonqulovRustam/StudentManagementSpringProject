package com.example.studentmanagementspring.service;

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
	
	
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
    
		return studentRepository.
				findById(id).
				orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student updateStudentInfoById(Integer id, Student updatedStudent) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		student.setName(updatedStudent.getName());
		student.setSurname(updatedStudent.getSurname());
		student.setGrade(updatedStudent.getGrade());
		student.setLevel(updatedStudent.getLevel());
		
		return studentRepository.save(student);
    }

	public void deleteStudentById(Integer id) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(
				"Student with id " + id + " not found"
		));
		
		studentRepository.delete(student);
	}

}
