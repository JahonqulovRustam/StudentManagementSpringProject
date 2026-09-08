package com.example.studentmanagementspring.repository;

import com.example.studentmanagementspring.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Page<Student> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(
			String name,
			String surname,
			Pageable pageable
	);
}
