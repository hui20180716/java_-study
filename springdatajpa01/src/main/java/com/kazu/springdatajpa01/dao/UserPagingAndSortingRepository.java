package com.kazu.springdatajpa01.dao;

import com.kazu.springdatajpa01.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 支持分页排序
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User,Integer> {
}
