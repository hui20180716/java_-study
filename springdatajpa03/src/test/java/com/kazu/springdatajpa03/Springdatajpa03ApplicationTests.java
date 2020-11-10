package com.kazu.springdatajpa03;

import com.kazu.springdatajpa03.Dao.StudentRepository;
import com.kazu.springdatajpa03.entity.Grade;
import com.kazu.springdatajpa03.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Springdatajpa03ApplicationTests {
    @Resource
    private StudentRepository studentRepository;

    /**
     * 一对一
     */
    @Test
    void contextLoads() {
        Student student = new Student();
        student.setStudentName("张浩");
        student.setGrade(new Grade("S1"));
        studentRepository.save(student);
    }
    /**
     * 一对一
     */
    @Test
    void contextLoads2() {

        Optional<Student> s=studentRepository.findById(1);

            System.out.println("................"+s);
        System.out.println(".."+s.get());
        System.out.println(s.get().getStudentName());

    }
}
