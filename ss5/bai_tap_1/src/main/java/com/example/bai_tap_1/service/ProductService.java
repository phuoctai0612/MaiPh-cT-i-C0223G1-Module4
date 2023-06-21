package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.repository.ConnectionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductService implements IProductService{
private final static String SELECT_ALL_PRODUCT="form Product";
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {
        Session session=null;
        Transaction transaction=null;
        try {
            session= ConnectionUtils.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
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

    }

    @Override
    public List<Product> findList(String search) {
        return null;
    }
}
