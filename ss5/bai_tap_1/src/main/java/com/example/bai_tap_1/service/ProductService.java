package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.repository.ConnectionUtils;
import com.example.bai_tap_1.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update( Product product) {
       iProductRepository.update(product);
    }

    @Override
    public void remove(Product product) {
        iProductRepository.remove(product);
    }

    @Override
    public List<Product> findList(String search) {
        return iProductRepository.findList(search);
    }
}
