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
            add(new Product(1,"Apple",10000.0,"Đẹp","Iphone"));
            add(new Product(2,"Iphone",123000.0,"Đẹp","Android"));
            add(new Product(3,"Banh",1345000.0,"Đẹp","Cookie"));
            add(new Product(4,"Keo",1450000.0,"Đẹp","Candy"));
            add(new Product(5,"aBc",4550000.0,"Đẹp","ABc"));
            add(new Product(6,"Laptop",45000.0,"Đẹp","Asus"));
            add(new Product(7,"ball",4545000.0,"CD","DragonBall"));
            add(new Product(8,"BatMan",345000.0,"Rich","0-3"));
            add(new Product(9,"Naruto",345000.0,"CD","0-3"));
            add(new Product(10,"PC",3452000.0,"Đẹp","Predator"));
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

    @Override
    public List<Product> findList(String search) {
        List<Product> list=new ArrayList<>();
        for (Product p: productList) {
            if (p.getName().contains(search)){
                list.add(p);
            }
        }
        return list;
    }
}
