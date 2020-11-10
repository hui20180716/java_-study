package com.kazu.springdatajpa02.dao;

import com.kazu.springdatajpa02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
 //注意：方法的名称必须要遵循驼峰式命名规则。xxxxBy(关键字)+属性名称（首字母大写）+查询条件（首字母大写）
    //根据名称精确查询
 List<User> findByUserName(String username);
 //根据用户名模糊查询
 List<User> findByUserNameLike(String username);

 /**
  * 根据姓名和地址模糊查询
  * @param username
  * @param address
  * @return
  */
 List<User> queryByUserNameLikeAndAddressLike(String username,String address);

 /**
  * 根据用户名模糊查询
  */
 @Query("from User  WHERE userName like %?1%")
 List<User> findUserByName(String username);

 @Query("from User where userName like %?1% and address like %?2%")
 List <User> findUserByNameAndAddress(String username,String address);

 @Query(value = "select  * from t_user where user_name like %?1% and address like %?2%" ,nativeQuery = true)
 List <User> queryUserByNameAndAddress(String username,String address);
}
