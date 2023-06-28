package com.example.demo.repository;

import com.example.demo.model.IdBookingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IIdBookingBookRepository extends JpaRepository<IdBookingBook,Integer> {
@Query(value = "select * from id_booking_book where book_id = :id",nativeQuery = true)
    List<IdBookingBook> getListBooking(@Param("id") int id);
     IdBookingBook findByIdBooking(String id);
    @Query(value = "select * from id_booking_book where book_id = :id and borrow = true",nativeQuery = true)
    List<IdBookingBook> getListBookingIsTrue(@Param("id") int id);
}
