package com.trainingwithdbexample.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingwithdbexample.dto.StudentDto;
import com.trainingwithdbexample.entity.Student;
import com.trainingwithdbexample.exception.SyntaxError;
import com.trainingwithdbexample.repository.StudentRepository;
import com.trainingwithdbexample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	@Override
	public void addStudentDetails(Student student) {
		logger.info("Student details data inserting operation start");
		try {
		Student s = studentRepository.save(student);
		logger.info("Student details data inserting operation completed");}
		catch(Exception e) {
			logger.error("Unable to insert data in DB");
			throw new SyntaxError("Table is not upto date");
		}
		
		
	}
	@Override
	public StudentDto getDetails(int id) {
		 Student o = studentRepository.getById(id);
		 
		 StudentDto studentDto = new StudentDto();
		 studentDto.setId(o.getId());
		 studentDto.setClassName(o.getClassName());
		 studentDto.setName(o.getName());
		 studentDto.setSchool(o.getSchool());
		return studentDto;
		
	}
	@Override
	public void update(Student student) {
		studentRepository.save(student);
	}
	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
		
	}

}
