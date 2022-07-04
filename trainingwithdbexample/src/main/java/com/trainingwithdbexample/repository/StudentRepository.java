package com.trainingwithdbexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingwithdbexample.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
