package com.example.bai_tap_1.service;

import com.example.bai_tap_1.model.Blog;
import com.example.bai_tap_1.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> getAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public void createBlog(Blog blog) {
         iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
      iBlogRepository.deleteById(id);
    }

    @Override
    public void editBlog(Blog blog) {
     iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> getListSearch(String name) {
        return iBlogRepository.searchBlog(name);
    }

    @Override
    public Blog findBlogByID(int id) {
          return iBlogRepository.findById(id).orElse(null);

    }
}
