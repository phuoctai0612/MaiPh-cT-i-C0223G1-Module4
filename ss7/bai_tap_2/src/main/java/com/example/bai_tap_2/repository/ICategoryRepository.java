package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.model.Blog;
import com.example.bai_tap_2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findBlogByIdFlagDeleteIsFalse();

}
