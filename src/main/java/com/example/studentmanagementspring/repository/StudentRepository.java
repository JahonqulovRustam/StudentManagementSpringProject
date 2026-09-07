package com.example.studentmanagementspring.repository;

import com.example.studentmanagementspring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}
