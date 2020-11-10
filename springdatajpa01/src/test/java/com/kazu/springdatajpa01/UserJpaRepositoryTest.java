package com.kazu.springdatajpa01;

import com.kazu.springdatajpa01.dao.UserJpaRepositTory;
import com.kazu.springdatajpa01.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTest {
    @Resource
    private UserJpaRepositTory  userJpaRepositTory;
    @Test
    public void testSort(){
       List<User> userList = userJpaRepositTory.findAll();
       for (User user:userList){
           System.out.println(user);

       }
    }
}
