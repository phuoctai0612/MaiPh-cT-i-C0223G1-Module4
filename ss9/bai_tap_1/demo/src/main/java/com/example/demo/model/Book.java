package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer id;
    private String name;
    private int amount;
    private boolean flagDelete;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<IdBookingBook> bookList;

    public Book() {
    }

    public Book(Integer id, String name, int amount, boolean flagDelete, List<IdBookingBook> bookList) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.flagDelete = flagDelete;
        this.bookList = bookList;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<IdBookingBook> getBookList() {
        return bookList;
    }

    public void setBookList(List<IdBookingBook> bookList) {
        this.bookList = bookList;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
