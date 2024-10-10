package com.example.food_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food_store.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    long count();

    Page<Product> findAll(Pageable page);
}
