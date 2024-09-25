package com.example.food_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.food_store.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User people);

}