package com.kazu.springdatajpa01.dao;

import com.kazu.springdatajpa01.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

}
