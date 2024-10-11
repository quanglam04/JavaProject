package com.example.food_store.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.food_store.domain.Product;
import com.example.food_store.domain.Product_;

public class ProductSpecification {
    public static Specification<Product> nameLike(int x, int y) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(Product_.PRICE), x, y);
    }
}
