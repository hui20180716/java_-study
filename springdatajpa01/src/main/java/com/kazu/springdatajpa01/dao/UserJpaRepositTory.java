package com.kazu.springdatajpa01.dao;

import com.kazu.springdatajpa01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 支持动态条件查询，分页，排序
 */
public interface UserJpaRepositTory extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
