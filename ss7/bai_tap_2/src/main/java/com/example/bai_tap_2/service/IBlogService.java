package com.example.bai_tap_2.service;

import com.example.bai_tap_2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void createBlog(Blog blog);
    void deleteBlog(Blog blog);
    void editBlog(Blog blog);
    Page<Blog> getListSearch(String name,String category,Pageable pageable);
    Blog findBlogByID(int id);
    Page<Blog> findBlogByIdFlagDeleteIsFalse(Pageable pageable);
}
