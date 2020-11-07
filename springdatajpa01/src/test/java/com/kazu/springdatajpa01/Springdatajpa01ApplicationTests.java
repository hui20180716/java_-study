package com.kazu.springdatajpa01;

import com.kazu.springdatajpa01.dao.UserRepository;
import com.kazu.springdatajpa01.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
class Springdatajpa01ApplicationTests {
    @Resource
    private UserRepository userRepository;
    //测试新增
    @Test
    void testAddUser() {
        User user = new User("老何",20,"湖北武汉");
        userRepository.save(user);
    }
//测试修改
@Test
void testUpdateUser() {
    User user = new User(3,"老何花",20,"湖北武汉");
    userRepository.save(user);
}
@Test
    public void testFindById(){
    Optional<User> user=userRepository.findById(1);
    System.out.print(user.toString());
    System.out.print(user.get().getId());
}
}
