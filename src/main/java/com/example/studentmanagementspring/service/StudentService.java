package com.example.studentmanagementspring.service;

import com.example.studentmanagementspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

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
        List<Student> students = new ArrayList<>();

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

        return students;
    }
}
