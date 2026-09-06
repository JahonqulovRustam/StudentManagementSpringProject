package com.example.studentmanagementspring.service;

import com.example.studentmanagementspring.exception.StudentNotFoundException;
import com.example.studentmanagementspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Integer nextId = 5;

    public StudentService() {
        students.add(new Student(
                1,
                "Rustam",
                "Jahonqulov",
                92.3,
                2
        ));
        students.add(new Student(
                2,
                "Amin",
                "To'xtayev",
                60.0,
                2
        ));
        students.add(new Student(
                4,
                "Kamron",
                "Hasanov",
                74.6,
                4
        ));
    }


    public Student getStudents() {
        return new Student(
                1,
                "Ali",
                "Valiyev",
                85.5,
                2
        );
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Integer id) {
        for (Student s : getAllStudents()) {
            if (Objects.equals(s.getId(), id)) {
                return s;
            }
        }

        throw new StudentNotFoundException("Student with id " + id + " not found");
    }

    public Student createStudent(Student student) {

        student.setId(nextId);
        nextId++;

        students.add(student);

        return student;
    }

    public Student updateStudentInfoById(Integer id, Student updatedStudent) {

        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                student.setName(updatedStudent.getName());
                student.setSurname(updatedStudent.getSurname());
                student.setGrade(updatedStudent.getGrade());
                student.setLevel(updatedStudent.getLevel());

                return student;
            }
        }

        throw new StudentNotFoundException("Student with id " + id + " not found");
    }
	
	public void deleteStudentById(Integer id) {
		
		boolean removed = students.removeIf(
				student -> Objects.equals(student.getId(), id)
		);
		
		if (!removed) {
			throw new StudentNotFoundException("Student with id " + id + " not found");
		}
	}
	
}
