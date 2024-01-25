package com.atdev.studentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atdev.studentManagementSystem.dto.StudentDTO;
import com.atdev.studentManagementSystem.model.Student;
import com.atdev.studentManagementSystem.service.StudentService;

@RestController
@RequestMapping ("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//For Getting list of all students
	@GetMapping("/")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	//To find student by Student id 
	@GetMapping("/{id}")
	 public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

	//For adding the student
    @PostMapping("/")
    public Student saveStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return studentService.saveStudent(student);
    }

    //For updating the student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent != null) {
            existingStudent.setName(studentDTO.getName());
            existingStudent.setAge(studentDTO.getAge());
            return studentService.saveStudent(existingStudent);
        } else {
            return null; // Handle not found scenario
        }
    }

    //For deleting the student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
