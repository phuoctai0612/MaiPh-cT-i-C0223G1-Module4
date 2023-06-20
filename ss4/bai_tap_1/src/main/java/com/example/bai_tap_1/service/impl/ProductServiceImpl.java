package com.example.bai_tap_1.service.impl;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.repository.IProductRepository;
import com.example.bai_tap_1.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
@Autowired
private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
   productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {
     productRepository.remove(id);
    }
}
