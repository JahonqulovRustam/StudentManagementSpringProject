package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.dto.*;
import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
	
	@GetMapping("/students")
	public Page<StudentResponse> getAllStudents(Pageable pageable) {
		return studentService.getStudents(pageable);
	}
	
	@GetMapping("/students/{id}")
	public StudentResponse getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}

    @PostMapping("/students")
    public StudentResponse create(@Valid @RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }
	
	
	@PutMapping("/students/{id}")
	public StudentResponse updateStudentInfoById(
			@PathVariable Integer id,
			@Valid @RequestBody StudentRequest request) {
		
		return studentService.updateStudentInfoById(id, request);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudentById(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
	}
	
	@GetMapping("/students/search")
	public Page<StudentResponse> searchByName(@RequestParam String name, Pageable pageable) {
		return studentService.searchByName(name, pageable);
	}
}