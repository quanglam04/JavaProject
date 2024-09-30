package com.example.food_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.food_store.domain.Product;
import com.example.food_store.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product prd) {
        return this.productRepository.save(prd);
    }

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }
}
