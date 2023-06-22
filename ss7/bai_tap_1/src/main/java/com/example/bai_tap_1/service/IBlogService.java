package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    void createBlog(Blog blog);
    void deleteBlog(int id);
    void editBlog(Blog blog);
    List<Blog> getListSearch(String name);
    Blog findBlogByID(int id);
}
