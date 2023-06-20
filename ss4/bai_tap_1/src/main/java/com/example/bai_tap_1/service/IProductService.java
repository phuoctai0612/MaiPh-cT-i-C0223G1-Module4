package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.Product;


import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
