package com.trainingwithdbexample.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingwithdbexample.entity.Student;
import com.trainingwithdbexample.repository.StudentRepository;
import com.trainingwithdbexample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Override
	public void addStudentDetails(Student student) {
		
		studentRepository.save(student);
	}

}
