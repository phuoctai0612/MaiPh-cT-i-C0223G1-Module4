package com.example.demo.service;



import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {

    void createBlog(Category category);
    void deleteBlog(Category category);
    void editBlog(Category category);
    Category findBlogByID(int id);
    List<Category> findBlogByIdFlagDeleteIsFalse();
}
