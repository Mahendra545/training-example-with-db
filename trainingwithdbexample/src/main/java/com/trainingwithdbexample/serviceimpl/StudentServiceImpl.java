package com.trainingwithdbexample.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingwithdbexample.dto.StudentDto;
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
