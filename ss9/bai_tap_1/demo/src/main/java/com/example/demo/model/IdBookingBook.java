package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class IdBookingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String idBooking;
    private LocalDateTime timeBooking;
    private LocalDateTime timeReturnBook;
    private boolean borrow;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public IdBookingBook() {
    }

    public IdBookingBook(String idBooking, Book book) {
        this.idBooking = idBooking;
        this.book = book;
    }

    public IdBookingBook(Integer id, String idBooking, LocalDateTime timeBooking, LocalDateTime timeReturnBook, Book book,boolean borrow) {
        this.id = id;
        this.idBooking = idBooking;
        this.timeBooking = timeBooking;
        this.timeReturnBook = timeReturnBook;
        this.book = book;
        this.borrow=borrow;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDateTime getTimeBooking() {
        return timeBooking;
    }

    public void setTimeBooking(LocalDateTime timeBooking) {
        this.timeBooking = timeBooking;
    }

    public LocalDateTime getTimeReturnBook() {
        return timeReturnBook;
    }

    public void setTimeReturnBook(LocalDateTime timeReturnBook) {
        this.timeReturnBook = timeReturnBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
