package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
