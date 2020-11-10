package com.kazu.springdatajpa01;

import com.kazu.springdatajpa01.dao.UserPagingAndSortingRepository;
import com.kazu.springdatajpa01.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPagingAndSortingRepositoryTest {
    @Resource
    private UserPagingAndSortingRepository userPagingAndSortingRepository;
    @Test
    public void testSort(){
        //创建排序对象（）

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        Iterable<User> iterable = userPagingAndSortingRepository.findAll(sort);
        Iterator<User> it =iterable.iterator();
        while(it.hasNext()){
            User user = it.next();
            System.out.print(user);
        }
    }


    @Test
    public void testPageSort(){
        //创建排序对象（）
        int pageNo=1;//当前页码
        int pageSize=2;

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        Iterable<User> iterable = userPagingAndSortingRepository.findAll(PageRequest.of(pageNo-1,pageSize, Sort.Direction.ASC,"id"));
        Iterator<User> it =iterable.iterator();
        while(it.hasNext()){
            User user = it.next();
            System.out.print(user);
        }
    }

}
