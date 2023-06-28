package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllByFlagDeleteIsFalse(Pageable pageable);
    void create(Book book);
    void delete(Book book);
    void edit(Book book);
    Book findBookById(int id);
}
