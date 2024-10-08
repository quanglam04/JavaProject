package com.example.food_store.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food_store.domain.Order;
import com.example.food_store.domain.User;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
