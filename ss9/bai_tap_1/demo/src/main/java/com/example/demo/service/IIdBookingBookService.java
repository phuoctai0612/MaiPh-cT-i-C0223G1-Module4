package com.example.demo.service;

import com.example.demo.model.IdBookingBook;

import java.util.List;

public interface IIdBookingBookService {
    List<IdBookingBook> getALl();
    List<IdBookingBook> getListBooking(int id);

    void create(IdBookingBook idBookingBook);

    void edit(IdBookingBook idBookingBook);

    IdBookingBook findIdBooking(String id);
    List<IdBookingBook> getListBookingIsTrue(int id);
}
