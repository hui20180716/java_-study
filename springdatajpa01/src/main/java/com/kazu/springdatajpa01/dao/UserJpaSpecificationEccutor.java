package com.kazu.springdatajpa01.dao;

import com.kazu.springdatajpa01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJpaSpecificationEccutor extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
