package com.kazu.springdatajpa02;

import com.kazu.springdatajpa02.dao.UserRepository;
import com.kazu.springdatajpa02.entity.User;
import com.sun.tracing.dtrace.Attributes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Springdatajpa02ApplicationTests {

    @Resource
    private UserRepository userRepository;
    @Test
    void contextLoads() {
        List<User> a= userRepository.findByUserName("tom");
        for(User u:a){
            System.out.println("......................"+u.toString());

        }
    }
    @Test
    void contextLoads2() {
        List<User> a= userRepository.findByUserNameLike("%o%");
        for(User u:a){
            System.out.println("......................"+u.toString());

        }
    }

    @Test
    void contextLoads3() {
        List<User> a= userRepository.findUserByName("o");
        for(User u:a){
            System.out.println("......................"+u.toString());

        }
    }

    @Test
    void contextLoads4() {
        List<User> a= userRepository.findUserByNameAndAddress("o","广州");
        for(User u:a){
            System.out.println("......................"+u.toString());

        }
    }

    @Test
    void contextLoads5() {
        List<User> a= userRepository.queryUserByNameAndAddress("o","广州");
        for(User u:a){
            System.out.println("......................"+u.toString());

        }
    }
}
