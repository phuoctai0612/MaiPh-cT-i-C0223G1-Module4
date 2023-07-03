package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cate")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")

    public ResponseEntity<List<Category>> getList() {
        if (this.categoryService.findBlogByIdFlagDeleteIsFalse().size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(this.categoryService.findBlogByIdFlagDeleteIsFalse(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id) {
        if (categoryService.findBlogByID(id) != null) {
            categoryService.findBlogByID(id).setIdFlagDelete(true);
            categoryService.deleteBlog(categoryService.findBlogByID(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody Category category) {
        categoryService.createBlog(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable int id, @RequestBody Category category) {

        if (categoryService.findBlogByID(id) != null) {
            categoryService.findBlogByID(id).setId(id);
            categoryService.editBlog(category);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
