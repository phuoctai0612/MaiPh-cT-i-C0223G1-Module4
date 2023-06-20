package com.example.bai_tap_1.repository.impl;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> productList=new ArrayList<Product>(){
        {
            add(new Product(1,"Iphone",10000.0,"Đẹp","Iphone"));
            add(new Product(2,"Iphone",123000.0,"Đẹp","Iphone"));
            add(new Product(3,"Iphone",1345000.0,"Đẹp","Iphone"));
            add(new Product(4,"Iphone",1450000.0,"Đẹp","Iphone"));
            add(new Product(5,"Iphone",4550000.0,"Đẹp","Iphone"));
            add(new Product(6,"Iphone",45000.0,"Đẹp","Iphone"));
            add(new Product(7,"Iphone",4545000.0,"Đẹp","Iphone"));
            add(new Product(8,"Iphone",345000.0,"Đẹp","Iphone"));
            add(new Product(9,"Iphone",345000.0,"Đẹp","Iphone"));
            add(new Product(10,"Iphone",3452000.0,"Đẹp","Iphone"));
        }
    };

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.set(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
      productList.remove(id);
    }
}
