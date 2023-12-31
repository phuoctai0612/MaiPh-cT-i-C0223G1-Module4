package com.example.demo.service;


import com.example.demo.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    void create(Product product);
    Product findById(int id);
}