package com.kazu.springdatajpa03.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
private  Integer id;
private String studentName;
//一对一
@OneToOne(cascade = CascadeType.PERSIST)
//外键列
@JoinColumn(name = "grade_id")
private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
