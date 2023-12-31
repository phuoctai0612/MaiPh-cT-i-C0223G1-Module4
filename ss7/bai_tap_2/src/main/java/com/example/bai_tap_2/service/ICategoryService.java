package com.example.bai_tap_2.service;

import com.example.bai_tap_2.model.Blog;
import com.example.bai_tap_2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    void createBlog(Category category);
    void deleteBlog(Category category);
    void editBlog(Category category);
    Category findBlogByID(int id);
    List<Category> findBlogByIdFlagDeleteIsFalse();
}
