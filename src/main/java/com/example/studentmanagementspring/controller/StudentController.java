package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.dto.*;
import com.example.studentmanagementspring.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(request));
    }
	
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentResponse> updateStudentInfoById(
			@PathVariable Integer id,
			@Valid @RequestBody StudentRequest request) {
		
		return ResponseEntity.ok(studentService.updateStudentInfoById(id, request));
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
		
		studentService.deleteStudentById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/students/search")
	public Page<StudentResponse> searchByName(@RequestParam String name, Pageable pageable) {
		return studentService.searchByName(name, pageable);
	}
	
	@PatchMapping("/students/{id}")
	public ResponseEntity<StudentResponse> patchUpdateStudentInfoById(@PathVariable Integer id, @Valid @RequestBody StudentPatchRequest patchRequest) {
		return ResponseEntity.ok(studentService.patchUpdateStudentInfoById(id, patchRequest));
	}
}