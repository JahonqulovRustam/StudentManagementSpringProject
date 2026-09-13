package com.example.studentmanagementspring.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "group")
	private List<Student> students;
	
	public Group() {}
	
	public Group(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
