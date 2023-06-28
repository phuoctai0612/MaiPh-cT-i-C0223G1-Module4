package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllByFlagDeleteIsFalse(Pageable pageable) {
        return iBookRepository.findAllByFlagDeleteIsFalse(pageable);
    }
    @Override
    public void create(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void edit(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findBookById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }
}
