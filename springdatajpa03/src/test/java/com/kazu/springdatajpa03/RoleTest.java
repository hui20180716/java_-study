package com.kazu.springdatajpa03;

import com.kazu.springdatajpa03.Dao.RolesRepositorye;
import com.kazu.springdatajpa03.entity.Role;
import com.kazu.springdatajpa03.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

    @Resource
    private com.kazu.springdatajpa03.Dao.RolesRepositorye RolesRepositorye;
    /**
     * 添加角色用户的同时添加用户
     */
    @Test
    public  void testAdd(){
        Role role = new Role("管理员");
        User user1 = new User();
        user1.setUserName("san");
        user1.setRole(role);
        User user2 = new User();
        user2.setUserName("si");
        user2.setRole(role);
        role.getUsers().add(user1);
        role.getUsers().add(user2);
        RolesRepositorye.save(role);
    }

    @Test
    public  void testFind(){

        Optional<Role> role= RolesRepositorye.findById(1);
        System.out.println(role.get().getUsers());
        for (User u:role.get().getUsers()){
            System.out.println(u);
        }

    }
}


