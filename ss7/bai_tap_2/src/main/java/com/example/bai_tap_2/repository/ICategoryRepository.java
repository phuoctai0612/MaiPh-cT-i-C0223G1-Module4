package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}
