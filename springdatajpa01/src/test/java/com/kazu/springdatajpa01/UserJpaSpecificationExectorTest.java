package com.kazu.springdatajpa01;

import com.kazu.springdatajpa01.dao.UserJpaRepositTory;
import com.kazu.springdatajpa01.dao.UserJpaSpecificationEccutor;
import com.kazu.springdatajpa01.entity.User;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserJpaSpecificationExectorTest {
    @Resource
    private com.kazu.springdatajpa01.dao.UserJpaSpecificationEccutor userJpaSpecificationEccutor;
    @Test
    public void testSory(){
        User user =new User();
        user.setUserName("aa");
        //创建排序对象（）
        int pageNo=1;//当前页码
        int pageSize=2;
        //定义分页对象
        PageRequest.of(pageNo-1,pageSize);

        Page<User> page =userJpaSpecificationEccutor.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(user!=null){
                    //root.get("实体类名")
                     if(user.getUserName()!=null && !user.getUserName().equals("")){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("userName"),"%"+user.getUserName()+"%"));

                     }
                     //年龄
                    if(user.getAge()!=null){
                        predicate.getExpressions().add(criteriaBuilder.ge(root.get("age"),user.getAge()));
                    }
                }
                return null;
            }
        },PageRequest.of(pageNo-1,pageSize));
       List<User> userlist = page.getContent();
       for(User u:userlist){
           System.out.println(u);
       }

}
}
