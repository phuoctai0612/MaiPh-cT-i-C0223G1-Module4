package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String name;

    private boolean idFlagDelete;
    public Category() {
    }

    public Category(Integer id, String name,boolean idFlagDelete) {
        this.id = id;
        this.name = name;
        this.idFlagDelete=idFlagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIdFlagDelete() {
        return idFlagDelete;
    }

    public void setIdFlagDelete(boolean idFlagDelete) {
        this.idFlagDelete = idFlagDelete;
    }
}
