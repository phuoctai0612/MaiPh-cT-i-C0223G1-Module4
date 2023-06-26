package com.example.bai_tap_2.service;

import com.example.bai_tap_2.model.Category;
import com.example.bai_tap_2.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public void createBlog(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void deleteBlog(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void editBlog(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findBlogByID(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findBlogByIdFlagDeleteIsFalse() {
        return iCategoryRepository.findBlogByIdFlagDeleteIsFalse();
    }
}
