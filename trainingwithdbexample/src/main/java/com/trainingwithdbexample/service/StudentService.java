package com.trainingwithdbexample.service;

import com.trainingwithdbexample.dto.StudentDto;
import com.trainingwithdbexample.entity.Student;

public interface StudentService {

	public void addStudentDetails(Student student);
	public StudentDto getDetails(int id);
	public void update(Student student);
	public void delete(int id);
}
