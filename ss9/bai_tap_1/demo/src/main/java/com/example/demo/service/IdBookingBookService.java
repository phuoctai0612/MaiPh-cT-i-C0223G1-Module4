package com.example.demo.service;

import com.example.demo.model.IdBookingBook;
import com.example.demo.repository.IIdBookingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdBookingBookService implements IIdBookingBookService{
    @Autowired
    private IIdBookingBookRepository iIdBookingBookRepository;

    @Override
    public List<IdBookingBook> getALl() {
        return iIdBookingBookRepository.findAll();
    }

    @Override
    public List<IdBookingBook> getListBooking(int id) {
        return iIdBookingBookRepository.getListBooking(id);
    }


    @Override
    public void create(IdBookingBook idBookingBook) {
        iIdBookingBookRepository.save(idBookingBook);
    }

    @Override
    public void edit(IdBookingBook idBookingBook) {
      iIdBookingBookRepository.save(idBookingBook);
    }

    @Override
    public IdBookingBook findIdBooking(String id) {
       return iIdBookingBookRepository.findByIdBooking(id);
    }

    @Override
    public List<IdBookingBook> getListBookingIsTrue(int id) {
        return iIdBookingBookRepository.getListBookingIsTrue(id);
    }
}
