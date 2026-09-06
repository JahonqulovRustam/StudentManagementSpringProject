package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public Student students() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public Student create(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudentInfoById(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        return studentService.updateStudentInfoById(id, updatedStudent);
    }
	
	@DeleteMapping("/students/{id}")
	public void deleteStudentById(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
	}
}