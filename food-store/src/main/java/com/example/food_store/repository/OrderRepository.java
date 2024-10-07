package com.example.food_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food_store.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
