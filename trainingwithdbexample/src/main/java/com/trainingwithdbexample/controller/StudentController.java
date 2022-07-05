package com.trainingwithdbexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainingwithdbexample.entity.Student;
import com.trainingwithdbexample.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/student/details")
	public String addStudentDetails(@RequestBody Student student)
	{
		studentService.addStudentDetails(student);
		return student.getName()+" added successfully";
	}
}
