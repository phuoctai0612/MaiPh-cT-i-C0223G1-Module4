package com.example.demo.service;


import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public void createBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> getListSearch(String name, String category, Pageable pageable) {
        return iBlogRepository.searchBlog(name, category, pageable);
    }

    @Override
    public Blog findBlogByID(int id) {
        return iBlogRepository.findById(id).orElse(null);

    }

    @Override
    public List<Blog> findBlogByIdFlagDeleteIsFalse() {
        return iBlogRepository.findBlogByIdFlagDeleteIsFalse();
    }


}
