package com.example.demo.service;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void createBlog(Blog blog);
    void deleteBlog(Blog blog);
    void editBlog(Blog blog);
    Page<Blog> getListSearch(String name,String category,Pageable pageable);
    Blog findBlogByID(int id);
    List<Blog> findBlogByIdFlagDeleteIsFalse();
}
