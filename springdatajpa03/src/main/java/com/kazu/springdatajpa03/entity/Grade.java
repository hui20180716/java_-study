package com.kazu.springdatajpa03.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String gradeName;
  //一对一
    //mappedby 维护外键关联关系 ，其中mappedby="grade",关系则学生实体类中的grade 维护
    @OneToOne(mappedBy = "grade")
    private Student student;

    public Grade() {
    }

    public Grade(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
