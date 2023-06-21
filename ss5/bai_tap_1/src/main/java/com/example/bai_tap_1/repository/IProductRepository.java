package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(Product product);

    List<Product> findList(String search);
}
