package com.example.studentmanagementspring.controller;

import com.example.studentmanagementspring.model.Student;
import com.example.studentmanagementspring.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return student;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }
}