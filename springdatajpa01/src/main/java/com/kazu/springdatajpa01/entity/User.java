package com.kazu.springdatajpa01.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")//当表明与实体类名一至时可以不写
public class User {
    @Id
    //主键自增策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    //设置实体类的属性名与表中的列表一一对应
    //当两名一致时，可省略不写

    private  String userName;
    @Column(name = "age")
    private  Integer age;
    private  String address;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public User(String userName, Integer age, String address) {
        this.userName = userName;
        this.age = age;
        this.address = address;
    }

    public User() {
    }

    public User(Integer id, String userName, Integer age, String address) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
