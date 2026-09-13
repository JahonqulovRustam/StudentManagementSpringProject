package com.example.studentmanagementspring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	@JsonIgnore
	private Group group;

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
