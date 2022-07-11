package com.trainingwithdbexample.service;

import java.sql.SQLSyntaxErrorException;

import com.trainingwithdbexample.dto.StudentDto;
import com.trainingwithdbexample.entity.Student;
import com.trainingwithdbexample.exception.SyntaxError;

public interface StudentService {

	public void addStudentDetails(Student student) throws  SQLSyntaxErrorException;
	public StudentDto getDetails(int id);
	public void update(Student student);
	public void delete(int id);
}
