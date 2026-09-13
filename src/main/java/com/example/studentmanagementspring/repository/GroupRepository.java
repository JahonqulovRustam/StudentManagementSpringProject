package com.example.studentmanagementspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentmanagementspring.model.*;

public interface GroupRepository extends JpaRepository<Group, Integer> {}
