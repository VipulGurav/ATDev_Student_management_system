package com.atdev.studentManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atdev.studentManagementSystem.model.Student;
import com.atdev.studentManagementSystem.repository.StudentRepository;



@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	
	//TO see the list of all students
	public List<Student> getAllStudents() {
		 return studentRepository.findAll();
	}
	
	//To find student by id
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
		
	}
	
	//TO save the student in the database
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}
	//To delete the student
	public void deleteStudent(Long id) {
		 studentRepository.deleteById(id);
		
	}
}
