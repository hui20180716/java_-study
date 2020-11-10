package com.kazu.springdatajpa03.Dao;

import com.kazu.springdatajpa03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student ,Integer> {

}
