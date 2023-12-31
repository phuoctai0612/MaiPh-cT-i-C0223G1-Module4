package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "mediumtext")
    private String name;
    private double price;
    @Column(columnDefinition = "mediumtext")
    private String description;
    @Column(columnDefinition = "mediumtext")
    private String img;

    public Product() {
    }

    public Product(String name, double price, String description,String img) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img=img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}