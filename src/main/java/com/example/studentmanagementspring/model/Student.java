package com.example.studentmanagementspring.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Double grade;
    private Integer level;

    public Student() {

    }

    public Student(Integer id, String name, String surname, Double grade, Integer level) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.level = level;
    }
}
