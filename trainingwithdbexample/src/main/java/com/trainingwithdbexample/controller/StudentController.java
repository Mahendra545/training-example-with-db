package com.trainingwithdbexample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainingwithdbexample.dto.StudentDto;
import com.trainingwithdbexample.entity.Student;
import com.trainingwithdbexample.service.StudentService;

@RestController
@Validated
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/student/details")
	public String addStudentDetails(@Valid @RequestBody Student student)
	{
		studentService.addStudentDetails(student);
		return student.getName()+" added successfully";
	}
	
	@GetMapping("/student/details/{id}")
	public StudentDto getDetails(@PathVariable int id) {
		return studentService.getDetails(id);
	}
	@PutMapping("/student/details/")
	public String update(@RequestBody Student student) {
		studentService.update(student);
		return student.getName()+" updated successfully";
	}
	@DeleteMapping("/student/details/{id}")
	public String delete(@PathVariable int id) {
		studentService.delete(id);
		return id+" deleted successfully";
	}
}
