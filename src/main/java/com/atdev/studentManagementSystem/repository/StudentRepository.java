package com.atdev.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atdev.studentManagementSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
